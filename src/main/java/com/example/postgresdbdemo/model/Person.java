// Person.java
package com.example.postgresdbdemo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "persons")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private Integer age;
}