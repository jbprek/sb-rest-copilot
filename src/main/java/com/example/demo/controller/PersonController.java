
package com.example.demo.controller;

import com.example.demo.service.PersonService;
import com.example.model.Person;

import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/persons")
@Tag(name = "Person API", description = "Operations related to Person management")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @Operation(summary = "Add a new person", description = "Creates a new person entry.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Person added successfully")
    })
    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @Operation(summary = "Delete a person", description = "Deletes a person by first and last name.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Person deleted successfully")
    })
    @DeleteMapping
    public void deletePerson(
            @Parameter(description = "First name of the person") @RequestParam String first,
            @Parameter(description = "Last name of the person") @RequestParam String last) {
        personService.deletePerson(first, last);
    }

    @Operation(summary = "Get all persons", description = "Returns a list of all persons.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of persons returned")
    })
    @GetMapping
    public Iterable<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @Operation(summary = "Find a person", description = "Finds a person by first and last name.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Person found")
    })
    @GetMapping("/find")
    public Optional<Person> findPerson(
            @Parameter(description = "First name of the person") @RequestParam String first,
            @Parameter(description = "Last name of the person") @RequestParam String last) {
        return personService.findPerson(first, last);
    }
}
