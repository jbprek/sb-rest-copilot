package com.example.demo.controller;

import com.example.demo.controller.Person;
import com.example.demo.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Optional;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PersonController.class)
class PersonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person("John", "Doe");
    }

    @Test
    void testAddPerson() throws Exception {
        mockMvc.perform(post("/api/persons")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"first\":\"John\",\"last\":\"Doe\"}"))
                .andExpect(status().isOk());
        verify(personService).addPerson(any(Person.class));
    }

    @Test
    void testDeletePerson() throws Exception {
        mockMvc.perform(delete("/api/persons?first=John&last=Doe"))
                .andExpect(status().isOk());
        verify(personService).deletePerson("John", "Doe");
    }

    @Test
    void testGetAllPersons() throws Exception {
        when(personService.getAllPersons()).thenReturn(List.of(person));
        mockMvc.perform(get("/api/persons"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].first").value("John"));
    }

    @Test
    void testFindPerson() throws Exception {
        when(personService.findPerson("John", "Doe")).thenReturn(Optional.of(person));
        mockMvc.perform(get("/api/persons/find?first=John&last=Doe"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.first").value("John"));
    }
}
