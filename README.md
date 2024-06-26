# Animal Web Application

This is a Spring Boot web application that allows users to manage a list of animals. Users can add, edit, delete, and view animals along with their details and images. The application also features a simple math problem as a CAPTCHA to prevent spam submissions.

## Features

- List all animals
- Add a new animal with an image
- Edit an existing animal
- Delete an animal
- View an animal's image
- Sort animals by name, category, or life expectancy
- CAPTCHA to prevent spam submissions

## Technologies Used

- Java
- Spring Boot
- Thymeleaf
- Spring Data JPA
- H2 Database (in-memory)
- Bootstrap for styling

## Getting Started

### Prerequisites

- Java 8 or later
- Maven

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/animal-web-app.git
    cd animal-web-app
    ```

2. Build the project:

    ```bash
    mvn clean install
    ```

3. Run the application:

    ```bash
    mvn spring-boot:run
    ```

4. Open your browser and navigate to `http://localhost:8080/animals`.

## Project Structure

- `src/main/java/com/example/AnimalWebApp`
  - `controller`: Contains the controllers for handling web requests.
  - `entity`: Contains the `Animal` entity.
  - `repository`: Contains the `AnimalRepository` interface for data access.
  - `service`: Contains the `AnimalService` class for business logic.

- `src/main/resources`
  - `templates`: Contains the Thymeleaf templates for the web pages.
  - `static/css`: Contains the CSS files for styling.
 
## Create the Database
Ensure you have a MySQL database named animal_db created. You can create it using the following SQL command:
```
CREATE DATABASE animalDatabase;
```
## Customizing the Application
### Adding New Fields to Animal Entity
1.Update the Animal class in src/main/java/com/example/AnimalWebApp/entity/Animal.java.  
2.Update the Thymeleaf templates in src/main/resources/templates to include the new fields.  
3.Update the controller and service classes to handle the new fields. 

### Changing the CAPTCHA Math Problem
The CAPTCHA logic is handled in the AnimalController class. You can update the addMathProblemToModel method to change the math problem

## Usage

### Listing Animals

Navigate to `/animals` to view the list of animals. You can sort the list by name, category, or life expectancy using the dropdown menu.

### Adding a New Animal

Navigate to `/animals/new` to add a new animal. Fill out the form, solve the math problem, and submit.


![Screenshot (325)](https://github.com/poojatajane18/AnimalWebApp/assets/92642653/37b7fd9a-72f1-460f-8302-115ff1e1391e)

![screencapture-localhost-8080-animals-new-2024-06-26-14_01_03](https://github.com/poojatajane18/AnimalWebApp/assets/92642653/87ef547b-4cfc-45f3-aaeb-0d3ccf4e0142)

![screencapture-localhost-8080-animals-2024-06-26-14_51_34](https://github.com/poojatajane18/AnimalWebApp/assets/92642653/1902ac69-19f7-43dc-888c-4a8824754413)

![Screenshot (326)](https://github.com/poojatajane18/AnimalWebApp/assets/92642653/35379dc3-83d5-4554-9b6b-2efdd289ee06)
