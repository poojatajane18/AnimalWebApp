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

## Usage

### Listing Animals

Navigate to `/animals` to view the list of animals. You can sort the list by name, category, or life expectancy using the dropdown menu.

### Adding a New Animal

Navigate to `/animals/new` to add a new animal. Fill out the form, solve the math problem, and submit.

![Screenshot (325)](https://github.com/poojatajane18/AnimalWebApp/assets/92642653/248c4d25-6da0-4eff-88f5-9a466aed95a9)

![screencapture-localhost-8080-![Uploading Screenshot (326).png…]()

animals-2024-06-26-14_51_34 (1)](https://github.com/poojatajane18/AnimalWebApp/assets/92642653/c7575378-c3a5-4b5c-8a1e-447792413631)

