package com.example.AnimalWebApp.controller;

import com.example.AnimalWebApp.entity.Animal;
import org.springframework.http.ResponseEntity;
import com.example.AnimalWebApp.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Random;
import java.io.IOException;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Controller
public class AnimalController {

    @Autowired
    private AnimalService animalService;
<<<<<<< HEAD
    
    
    //Shows the list of Animal
=======

    //Display the list of Animal 
>>>>>>> f4bc1f99eacbccd15d8fc3831040d9f8042b0048
    @GetMapping("/animals")
    public String listAnimals(Model model, @RequestParam(value = "sortBy", required = false) String sortBy) {
        List<Animal> animals = animalService.getAllAnimalsSorted(sortBy);
        model.addAttribute("animals", animals);
        model.addAttribute("sortBy", sortBy);
        return "animal-list";
    }
    
    //Shows the form for creating a new animal
    @GetMapping("/animals/new")
    public String showCreateForm(Model model) {
        model.addAttribute("animal", new Animal());
        addMathProblemToModel(model);
        return "animal-form";
    }

    //Saves the new animal to the Database
    @PostMapping("/animals")
    public String saveAnimal(@ModelAttribute("animal") Animal animal,
                             @RequestParam("file") MultipartFile file,
                             @RequestParam("mathAnswer") int mathAnswer,
                             @RequestParam("correctAnswer") int correctAnswer,
                             Model model) throws IOException {
        if (mathAnswer != correctAnswer) {
            model.addAttribute("errorMessage", "Math problem incorrect");
            addMathProblemToModel(model);
            return "animal-form";
        }
        try {
            if (!file.isEmpty()) {
                animal.setImage(file.getBytes());
            }
            animalService.saveAnimal(animal);
            model.addAttribute("successMessage", "Animal saved successfully!");
            return "redirect:/animals";
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("animal", animal);
            addMathProblemToModel(model);
            return "animal-form";
        }
    }

    
    //Shows the form for editing an existing animal
    @GetMapping("/animals/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Animal animal = animalService.getAnimalById(id);
        if (animal == null) {
            model.addAttribute("errorMessage", "Animal not found");
            return "redirect:/animals";
        }
        model.addAttribute("animal", animal);
        addMathProblemToModel(model);
        return "animal-form";
    }

    //Updates an existing animal in the database
    @PostMapping("/animals/{id}")
    public String updateAnimal(@PathVariable("id") Long id,
                               @ModelAttribute("animal") Animal animal,
                               @RequestParam("file") MultipartFile file,
                               @RequestParam("mathAnswer") int mathAnswer,
                               @RequestParam("correctAnswer") int correctAnswer,
                               Model model) throws IOException {
        if (mathAnswer != correctAnswer) {
            model.addAttribute("errorMessage", "Math problem incorrect");
            model.addAttribute("animal", animal);
            addMathProblemToModel(model);
            return "animal-form";
        }
        try {
            Animal existingAnimal = animalService.getAnimalById(id);
            if (existingAnimal == null) {
                model.addAttribute("errorMessage", "Animal not found");
                return "redirect:/animals";
            }
            if (!file.isEmpty()) {
                animal.setImage(file.getBytes());
            } else {
                animal.setImage(existingAnimal.getImage());
            }
            animalService.saveAnimal(animal);
            model.addAttribute("successMessage", "Animal updated successfully!");
            return "redirect:/animals";
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("animal", animal);
            addMathProblemToModel(model);
            return "animal-form";
        }
    }

    //Delete an animal from the database
    @GetMapping("/animals/delete/{id}")
    public String deleteAnimal(@PathVariable("id") Long id, Model model) {
        animalService.deleteAnimal(id);
        model.addAttribute("successMessage", "Animal deleted successfully!");
        return "redirect:/animals";
    }
    
    //Adds a simple math problem to the model for validation purpose
    private void addMathProblemToModel(Model model) {
        Random random = new Random();
        int num1 = random.nextInt(10) + 1;
        int num2 = random.nextInt(10) + 1;
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("answer", num1 + num2);
    }
    
    //Retrieves the image of an animal
    @GetMapping("/animals/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) {
        Animal animal = animalService.getAnimalById(id);
        if (animal == null || animal.getImage() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"image\"")
                .contentType(MediaType.IMAGE_JPEG)
                .body(animal.getImage());
    }
}
