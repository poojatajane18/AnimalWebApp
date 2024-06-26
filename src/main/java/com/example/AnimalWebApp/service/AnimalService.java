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

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public void saveAnimal(Animal animal) throws IllegalArgumentException{
    	validateAnimal(animal);
        animalRepository.save(animal);
    }

    public Animal getAnimalById(Long id) {
        return animalRepository.findById(id).orElse(null);
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }
    private void validateAnimal(Animal animal) throws IllegalArgumentException {
        if (StringUtils.isEmpty(animal.getName()) || StringUtils.isEmpty(animal.getCategory()) || 
            StringUtils.isEmpty(animal.getDescription()) || StringUtils.isEmpty(animal.getLifeExpectancy())) {
            throw new IllegalArgumentException("All fields are required.");
        }
    }
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
    /*
     *public List<Animal> getAllAnimalsSorted(String sortBy) {
        List<Animal> animals = getAllAnimals();
        if ("name".equalsIgnoreCase(sortBy)) {
            return animals.stream().sorted(Comparator.comparing(Animal::getName)).collect(Collectors.toList());
        } else if ("category".equalsIgnoreCase(sortBy)) {
            return animals.stream().sorted(Comparator.comparing(Animal::getCategory)).collect(Collectors.toList());
        } else if ("lifeExpectancy".equalsIgnoreCase(sortBy)) {
            return animals.stream().sorted(Comparator.comparingInt(this::mapLifeExpectancy)).collect(Collectors.toList());
        } else {
            return animals;
        }
    }

    private int mapLifeExpectancy(Animal animal) {
        switch (animal.getLifeExpectancy()) {
            case "2-5":
                return 1;
            case "5-10":
                return 2;
            case "10-20":
                return 3;
            case "20+":
                return 4;
            default:
                return 0;
        }
    }
     * */
}
