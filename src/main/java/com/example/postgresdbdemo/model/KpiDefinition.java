// KpiDefinition.java
package com.example.postgresdbdemo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "kpi_definitions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KpiDefinition {
    @Id
    private String kpiKey; // A–K

    private String description;
}