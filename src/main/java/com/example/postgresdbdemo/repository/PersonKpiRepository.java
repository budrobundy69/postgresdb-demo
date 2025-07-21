// PersonKpiRepository.java
package com.example.postgresdbdemo.repository;

import com.example.postgresdbdemo.model.PersonKpi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonKpiRepository extends JpaRepository<PersonKpi, Long> {
    List<PersonKpi> findByPersonIdAndKpi_KpiKeyIn(Long personId, List<String> keys);
}