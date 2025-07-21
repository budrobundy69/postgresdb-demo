// PersonCombinedController.java
package com.example.postgresdbdemo.controller;

import com.example.postgresdbdemo.dto.PersonWithKpiResponse;
import com.example.postgresdbdemo.model.Person;
import com.example.postgresdbdemo.model.PersonKpi;
import com.example.postgresdbdemo.repository.PersonKpiRepository;
import com.example.postgresdbdemo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.postgresdbdemo.dto.PersonWithKpiResponse.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/persons")
public class PersonCombinedController {

    private final PersonRepository personRepo;
    private final PersonKpiRepository kpiRepo;

    @PostMapping("/{id}/details")
    public PersonWithKpiResponse getPersonWithKpis(
            @PathVariable Long id,
            @RequestBody List<String> keys
    ) {
        Person person = personRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found: " + id));

        List<KpiEntry> selectedKpis = kpiRepo.findByPersonIdAndKpi_KpiKeyIn(id, keys)
                .stream()
                .map(kpi -> new KpiEntry(
                        kpi.getKpi().getKpiKey(),
                        kpi.getPValue(),
                        kpi.getSValue(),
                        kpi.getTValue()
                ))
                .collect(Collectors.toList());

        return new PersonWithKpiResponse(person, selectedKpis);
    }
}