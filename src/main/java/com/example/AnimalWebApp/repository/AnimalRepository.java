package com.example.AnimalWebApp.repository;

import com.example.AnimalWebApp.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
	
}
