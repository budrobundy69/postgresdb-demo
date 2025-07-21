// PersonWithKpiResponse.java
package com.example.postgresdbdemo.dto;

import com.example.postgresdbdemo.model.Person;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonWithKpiResponse {
    private Person person;
    private List<KpiEntry> kennzahlen;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class KpiEntry {
        private String key;
        private double pValue;
        private double sValue;
        private double tValue;
    }
}