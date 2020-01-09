package ke.co.codingcamp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ke.co.codingcamp.entities.Tenant;
import ke.co.codingcamp.services.TenantsService;

@RestController
public class TenantsController{

    @Autowired
    private TenantsService tenantsService;

    @GetMapping("/api/v1/tenants/")
    public ResponseEntity<List<Tenant>> all(){

        List<Tenant> allTenants = tenantsService.findAllTenants();
        return ResponseEntity.ok(allTenants);
    }
}