package com.rzepecki.petclinic.repositories;

import com.rzepecki.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
