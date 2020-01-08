package com.rzepecki.petclinic.repositories;

import com.rzepecki.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
