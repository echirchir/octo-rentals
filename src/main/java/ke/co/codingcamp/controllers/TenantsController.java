package ke.co.codingcamp.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ke.co.codingcamp.entities.Tenant;
import ke.co.codingcamp.services.TenantsService;

@RestController
public class TenantsController{

    @Autowired
    private TenantsService tenantsService;

    @GetMapping("/api/v1/tenants")
    public ResponseEntity<List<Tenant>> all(){
        
        List<Tenant> allTenants = tenantsService.findAll();
        
        return ResponseEntity.ok(allTenants);
        
    }

    @PostMapping("/api/v1/tenants")
    public ResponseEntity<Tenant> create(@RequestBody Tenant rental) throws URISyntaxException {

        Tenant createdTenant = tenantsService.create(rental);

        if (createdTenant == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(createdTenant.getId())
            .toUri();
    
            return ResponseEntity.created(uri).body(createdTenant);
        }
    }

    @GetMapping("/api/v1/tenants/{id}")
    public ResponseEntity<Tenant> read(@PathVariable("id") Integer id) {

        Tenant tenant = tenantsService.findById(id);

        if (tenant == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(tenant);
        }
    }

    @PutMapping("/api/v1/tenants/{id}")
    public ResponseEntity<Tenant> update(@RequestBody Tenant tenant, @PathVariable Integer id) {

        Tenant updatedTenant = tenantsService.update(id, tenant);

        if (updatedTenant == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedTenant);
        }
    }

    @DeleteMapping("/api/v1/tenants/{id}")
    public ResponseEntity<Tenant> delete(@PathVariable Integer id) {

        tenantsService.delete(id);

        return ResponseEntity.ok(null);
    }
}