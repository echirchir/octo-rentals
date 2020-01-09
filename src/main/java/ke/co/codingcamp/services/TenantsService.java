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

    public List<Tenant> findAllTenants(){

        return tenantsRepository.findAll();
    }

    public Integer saveTenant(Tenant tenant){

        Tenant savedTenant = tenantsRepository.save(tenant);

        return savedTenant.getId();
    }

    public Integer updateTenant(Tenant tenant){

        Tenant updatedTenant = tenantsRepository.save(tenant);

        return updatedTenant.getId();

    }

    public void deleteTenant(Tenant tenant){

        tenantsRepository.delete(tenant);

    }
}