package ke.co.codingcamp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ke.co.codingcamp.entities.Rental;
import ke.co.codingcamp.entities.Tenant;
import ke.co.codingcamp.repositories.RentalsRepository;
import ke.co.codingcamp.repositories.TenantsRepository;

@Service
public class RentalsService{

    @Autowired
    private RentalsRepository rentalsRepository;

    @Autowired
    private TenantsRepository tenantsRepository;

    public List<Rental> findAll(){

        return rentalsRepository.findAll();
    }

    public Rental findById(Integer id){

        return rentalsRepository.findById(id).orElse(null);
    }

    public Rental create(Rental rental, Integer id){

        Tenant tenant = tenantsRepository.findById(id).orElse(null);

        if (tenant != null){
            rental.setTenant(tenant);
        }

        return rentalsRepository.save(rental);
    }

    public Rental update(Integer id, Rental rental, Integer tenantId){

        Tenant newTenant = tenantsRepository.findById(tenantId).orElse(null);

        if( newTenant != null){
            rental.setTenant(newTenant);
        }

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