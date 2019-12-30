package com.rzepecki.petclinic.services;

import com.rzepecki.petclinic.model.Pet;
import com.rzepecki.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
