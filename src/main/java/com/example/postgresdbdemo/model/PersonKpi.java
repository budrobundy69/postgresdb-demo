// PersonKpi.java
package com.example.postgresdbdemo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "person_kpis")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonKpi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double pValue;
    private double sValue;
    private double tValue;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "kpi_key")
    private KpiDefinition kpi;
}