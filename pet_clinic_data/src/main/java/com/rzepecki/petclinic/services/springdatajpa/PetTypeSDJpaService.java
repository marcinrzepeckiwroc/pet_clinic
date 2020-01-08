package com.rzepecki.petclinic.services.springdatajpa;


import com.rzepecki.petclinic.model.PetType;
import com.rzepecki.petclinic.repositories.PetTypesReposiotry;
import com.rzepecki.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private final PetTypesReposiotry petTypesReposiotry;

    public PetTypeSDJpaService(PetTypesReposiotry petTypesReposiotry) {
        this.petTypesReposiotry = petTypesReposiotry;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypeSet = new HashSet<>();
        petTypesReposiotry.findAll().forEach(petTypeSet::add);
        return petTypeSet;
    }

    @Override
    public PetType findById(Long id) {
        return petTypesReposiotry.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypesReposiotry.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypesReposiotry.delete(object);
    }

    @Override
    public void deleteAllById(Long id) {
        petTypesReposiotry.deleteById(id);
    }
}
