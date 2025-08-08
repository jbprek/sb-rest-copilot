package com.example.demo.controller;

import com.example.demo.controller.Person;
import com.example.demo.service.PersonService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @DeleteMapping
    public void deletePerson(@RequestParam String first, @RequestParam String last) {
        personService.deletePerson(first, last);
    }

    @GetMapping
    public Iterable<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/find")
    public Optional<Person> findPerson(@RequestParam String first, @RequestParam String last) {
        return personService.findPerson(first, last);
    }
}
