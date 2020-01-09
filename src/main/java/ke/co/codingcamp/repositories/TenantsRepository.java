package ke.co.codingcamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ke.co.codingcamp.entities.Tenant;

@Repository
public interface TenantsRepository extends JpaRepository<Tenant, Integer>{

    
}