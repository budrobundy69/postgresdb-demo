package com.example.postgresdbdemo.controller;


import com.example.postgresdbdemo.model.Person;
import com.example.postgresdbdemo.repository.PersonRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonRepository personRepository;

    @BeforeEach
    void setup() {
        personRepository.deleteAll();
        personRepository.save(new Person(null, "Alice", "Test", 42));
    }

    @Test
    @Order(1)
    void shouldReturnAllPersons() throws Exception {
        mockMvc.perform(get("/api/persons"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    @Order(2)
    void shouldCreateNewPerson() throws Exception {
        String body = """
        {
          "firstName": "Bob",
          "lastName": "Tester",
          "age": 33
        }
        """;

        mockMvc.perform(post("/api/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.firstName").value("Bob"));
    }
}
