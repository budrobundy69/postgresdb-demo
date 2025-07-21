// PersonRepository.java
package com.example.postgresdbdemo.repository;

import com.example.postgresdbdemo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}