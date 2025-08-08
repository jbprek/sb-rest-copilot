package com.example.demo.service;

import com.example.demo.controller.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {
    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService();
    }

    @Test
    void testAddAndFindPerson() {
        Person person = new Person("John", "Doe");
        personService.addPerson(person);
        Optional<Person> found = personService.findPerson("John", "Doe");
        assertTrue(found.isPresent());
        assertEquals("John", found.get().first());
        assertEquals("Doe", found.get().last());
    }

    @Test
    void testDeletePerson() {
        Person person = new Person("Jane", "Smith");
        personService.addPerson(person);
        personService.deletePerson("Jane", "Smith");
        assertFalse(personService.findPerson("Jane", "Smith").isPresent());
    }

    @Test
    void testGetAllPersons() {
        personService.addPerson(new Person("A", "B"));
        personService.addPerson(new Person("C", "D"));
        int count = 0;
        for (Person p : personService.getAllPersons()) {
            count++;
        }
        assertEquals(2, count);
    }
}
