package com.example.demo.service;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.example.model.Person;

import java.util.Map;
import java.util.Optional;

@Service
public class PersonService {
    private final Map<String, Person> personMap = new ConcurrentHashMap<>();

    // Adds a person. Uses first+last as key for simplicity.
    public void addPerson(Person person) {
        personMap.put(person.first() + ":" + person.last(), person);
    }

    // Deletes a person by first and last name.
    public void deletePerson(String first, String last) {
        personMap.remove(first + ":" + last);
    }

    // Finds a person by first and last name.
    public Optional<Person> findPerson(String first, String last) {
        return Optional.ofNullable(personMap.get(first + ":" + last));
    }

    // Returns all Person entries
    public Iterable<Person> getAllPersons() {
        return personMap.values();
    }
}
