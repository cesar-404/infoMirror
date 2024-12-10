![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

# Info Mirror

## 📝 About

This program is a Spring Boot application that provides a RESTful API for managing users. It includes a UserController class that defines an endpoint for creating new users. The controller uses a UserDto object to receive data in the request body, validates it using @Valid, and then delegates the logic of saving the user to a UserService instance. The service handles the business logic for persisting the user data. The application also includes Spring Boot's auto-configurations for web, validation, and message converters, which ensure smooth operation of HTTP requests, data binding, and JSON serialization.

## 🔩 Challenge
The challenge of this project was to implement a robust REST API with proper validation and error handling, ensuring smooth integration between the user controller, service layers, and database, while maintaining scalability and reliability.

## ✏️ Theme
The theme of this project is building a RESTful API for user management, focusing on user creation, validation, and interaction with a service layer and database using Java, Spring Boot, and PostgreSQL.

## ⚙️ Technologies

- Java 23
- Spring Boot 3
- Docker
- MVC
- Spring Web
- Spring JPA
- Spring Validation
- Junit5
- Mockito
- Spring WebFlux
- WebClient

## 🕹 Running the project

### prerequisites

- Java (version 11 or above) - to run the Spring Boot application.
- Maven - for building the project
- Drocker to run the docker-compose with PostgreSQL

Clone the repository

```bash
git clone https://github.com/cesar-404/infoMirror
cd infoMirror
```

Run the project

```bash
mvn clean install
mvn spring-boot:run
```

### Test the API
- After the application starts, you can test the API using tools like Postman or Insomnia:
- The API should be running on http://localhost:8080.
- Example: To create a user, make a POST request to http://localhost:8080/api/create with the appropriate JSON body.

### Example of the API running

#### Image

![image](/src/content/Screenshot%20From%202024-12-10%2018-42-23.png)

