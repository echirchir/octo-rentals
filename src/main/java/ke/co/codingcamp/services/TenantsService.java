package ke.co.codingcamp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ke.co.codingcamp.entities.Tenant;
import ke.co.codingcamp.repositories.TenantsRepository;

@Service
public class TenantsService{
    

    @Autowired
    private TenantsRepository tenantsRepository;

    public List<Tenant> findAll(){

        return tenantsRepository.findAll();
    }

    public Tenant findById(Integer id){

        return tenantsRepository.findById(id).orElse(null);
    }

    public Tenant create(Tenant tenant){

        return tenantsRepository.save(tenant);
    }

    public Tenant update(Integer id, Tenant tenant){

        Tenant toUpdate = tenantsRepository.findById(id).orElse(null);

        if (toUpdate == null){
            return null;
        }else{
            return tenantsRepository.save(tenant);
        }


    }

    public void delete(Integer id){

        Tenant toDelete = tenantsRepository.findById(id).orElse(null);

        if (toDelete != null){
            tenantsRepository.deleteById(id);
        }

    }
}