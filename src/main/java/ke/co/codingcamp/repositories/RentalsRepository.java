package ke.co.codingcamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ke.co.codingcamp.entities.Rental;

@Repository
public interface RentalsRepository extends JpaRepository<Rental, Integer>{

    
}