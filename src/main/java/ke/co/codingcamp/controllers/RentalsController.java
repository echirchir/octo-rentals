package ke.co.codingcamp.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
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

import ke.co.codingcamp.entities.Rental;
import ke.co.codingcamp.services.RentalsService;

@RestController
public class RentalsController{

    @Autowired
    private RentalsService rentalsService;

    @GetMapping("/api/v1/rentals")
    public ResponseEntity<List<Rental>> all(){
        
        List<Rental> allRentals = rentalsService.findAll();

        System.out.println(allRentals.size());

        return ResponseEntity.ok(allRentals);

        /*List<Rental> list = new ArrayList<>();
        list.add(new Rental());
        list.add(new Rental());
        list.add(new Rental());

        return ResponseEntity.ok(list);*/
        
    }

    @PostMapping("/api/v1/rentals/{id}")
    public ResponseEntity<Rental> create(@RequestBody Rental rental, @PathVariable Integer id) throws URISyntaxException {

        Rental createdRental = rentalsService.create(rental, id);

        if (createdRental == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(createdRental.getId())
            .toUri();
    
            return ResponseEntity.created(uri).body(createdRental);
        }
    }

    @GetMapping("/api/v1/rentals/{id}")
    public ResponseEntity<Rental> read(@PathVariable("id") Integer id) {

        Rental rental = rentalsService.findById(id);

        if (rental == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(rental);
        }
    }

    @PutMapping("/api/v1/rentals/{id}/{tenant}")
    public ResponseEntity<Rental> update(@RequestBody Rental rental, @PathVariable Integer id, @PathVariable Integer tenant)

        Rental updatedRental = rentalsService.update(id, rental, tenant);
        
        if (updatedRental == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedRental);
        }
    }

    @DeleteMapping("/api/v1/rentals/{id}")
    public ResponseEntity<Rental> delete(@PathVariable Integer id) {

        rentalsService.delete(id);

        return ResponseEntity.noContent().build();
    }


}