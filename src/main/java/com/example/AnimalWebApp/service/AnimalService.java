package com.example.AnimalWebApp.service;

import com.example.AnimalWebApp.entity.Animal;

import com.example.AnimalWebApp.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;
    
    //Retrives all the animal from the repository
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    //Saves an animal to the repository after validating it
    public void saveAnimal(Animal animal) throws IllegalArgumentException{
    	validateAnimal(animal);
        animalRepository.save(animal);
    }

    //Retrieves an animal by its ID
    public Animal getAnimalById(Long id) {
        return animalRepository.findById(id).orElse(null);
    }

    //Delete an animal by ID
    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }
    
    //Check the validation all the field is fill or not
    private void validateAnimal(Animal animal) throws IllegalArgumentException {
        if (StringUtils.isEmpty(animal.getName()) || StringUtils.isEmpty(animal.getCategory()) || 
            StringUtils.isEmpty(animal.getDescription()) || StringUtils.isEmpty(animal.getLifeExpectancy())) {
            throw new IllegalArgumentException("All fields are required.");
        }
    }
    
    //Retrieves all animals from the repository sorted by field
    public List<Animal> getAllAnimalsSorted(String sortBy) {
        if ("name".equalsIgnoreCase(sortBy)) {
            return animalRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        } else if ("category".equalsIgnoreCase(sortBy)) {
            return animalRepository.findAll(Sort.by(Sort.Direction.ASC, "category"));
        } else if ("lifeExpectancy".equalsIgnoreCase(sortBy)) {
            return animalRepository.findAll(Sort.by(Sort.Direction.ASC, "lifeExpectancy"));
        } else {
            return getAllAnimals();
        }
    }
    
}
