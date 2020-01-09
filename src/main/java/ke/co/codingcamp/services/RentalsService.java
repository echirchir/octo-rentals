package ke.co.codingcamp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ke.co.codingcamp.entities.Rental;
import ke.co.codingcamp.repositories.RentalsRepository;

@Service
public class RentalsService{

    @Autowired
    private RentalsRepository rentalsRepository;

    public List<Rental> findAll(){

        return rentalsRepository.findAll();
    }

    public Rental findById(Integer id){

        return rentalsRepository.findById(id).orElse(null);
    }

    public Integer saveRental(Rental rental){

        Rental savedRental = rentalsRepository.save(rental);

        return savedRental.getId();
    }

    public Integer updateRental(Rental rental){

        Rental updatedRental = rentalsRepository.save(rental);

        return updatedRental.getId();
    }

    public void deleteRental(Integer id){

        rentalsRepository.deleteById(id);
    
    }

}