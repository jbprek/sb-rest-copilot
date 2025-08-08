# GitHub Copilot Instructions

This is a Spring Boot application written in Java. It follows a layered architecture with Controllers, Services, and Repositories.



## Project Goals
- Build a RESTful API for Person CRUD operations
- Person entity consists of first,last attributed
- Persistence is implemented using a map
- Use DTOs for data transfer between layers.
- Follow best practices for exception handling and validation.

# Implementation
- model class  model/Perfson.java
- service class service/PersonService.java
- controller class PersonController.java

## Coding Style
- Use `@RestController` for API endpoints.
- Use `@Service` for business logic.
- Use `@Repository` for data access.
- Prefer constructor injection over field injection.
- Use `ResponseEntity` for HTTP responses.
- Use Lombok annotations like `@Getter`, `@Setter`, and `@AllArgsConstructor`.

## Preferences

- Use pagination for list endpoints.
- Include Swagger annotations for API documentation.
