package com.rzepecki.petclinic.repositories;

import com.rzepecki.petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyReposiotry extends CrudRepository<Speciality, Long> {
}
