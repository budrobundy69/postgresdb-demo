// KpiDefinitionRepository.java
package com.example.postgresdbdemo.repository;

import com.example.postgresdbdemo.model.KpiDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KpiDefinitionRepository extends JpaRepository<KpiDefinition, String> {
}