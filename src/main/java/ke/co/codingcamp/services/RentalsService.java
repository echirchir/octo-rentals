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

    public Rental create(Rental rental){

        return rentalsRepository.save(rental);
    }

    public Rental update(Integer id, Rental rental){

        Rental toUpdate = rentalsRepository.findById(id).orElse(null);

        if (toUpdate == null){
            return null;
        }else{
            return rentalsRepository.save(rental);
        }
    }

    public void delete(Integer id){

        rentalsRepository.deleteById(id);
    
    }

}