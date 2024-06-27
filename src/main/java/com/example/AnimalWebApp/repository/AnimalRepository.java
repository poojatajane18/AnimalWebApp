package com.example.AnimalWebApp.repository;

import com.example.AnimalWebApp.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;


/*Repository interface for Animal entities
 * 
 * This interface use for CRUD Operation for Animal entitites
 */
public interface AnimalRepository extends JpaRepository<Animal, Long> {
	
}
