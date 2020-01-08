package com.rzepecki.petclinic.repositories;

import com.rzepecki.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypesReposiotry extends CrudRepository<PetType, Long> {
}
