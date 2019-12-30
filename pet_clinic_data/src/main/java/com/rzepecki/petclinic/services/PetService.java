package com.rzepecki.petclinic.services;

import com.rzepecki.petclinic.model.Owner;
import com.rzepecki.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
