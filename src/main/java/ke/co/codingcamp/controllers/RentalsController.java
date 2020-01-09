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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ke.co.codingcamp.entities.Rental;
import ke.co.codingcamp.services.RentalsService;

@RestController
public class RentalsController{

    @Autowired
    private RentalsService rentalsService;

    @GetMapping("/api/v1/rentals/")
    @ResponseBody
    public ResponseEntity<List<Rental>> all(){
        
        List<Rental> allRentals = rentalsService.findAll();

        if (allRentals.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(allRentals);
        }
        
    }

    @PostMapping("/api/v1/rentals/")
    public ResponseEntity<Rental> create(@RequestBody Rental rental) throws URISyntaxException {
        Rental createdRental = rentalsService.create(rental);
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

    @PutMapping("/api/v1/rentals/{id}")
    public ResponseEntity<Rental> update(@RequestBody Rental rental, @PathVariable Integer id) {

        Rental updatedRental = rentalsService.update(id, rental);
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