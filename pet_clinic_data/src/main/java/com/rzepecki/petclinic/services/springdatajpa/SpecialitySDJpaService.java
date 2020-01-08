package com.rzepecki.petclinic.services.springdatajpa;

import com.rzepecki.petclinic.model.PetType;
import com.rzepecki.petclinic.model.Speciality;
import com.rzepecki.petclinic.repositories.PetTypesReposiotry;
import com.rzepecki.petclinic.repositories.SpecialtyReposiotry;
import com.rzepecki.petclinic.services.PetTypeService;
import com.rzepecki.petclinic.services.SpecialitiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialitiesService {

    private final SpecialtyReposiotry specialtyReposiotry;

    public SpecialitySDJpaService(SpecialtyReposiotry specialtyReposiotry) {
        this.specialtyReposiotry = specialtyReposiotry;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialitySet = new HashSet<>();
        specialtyReposiotry.findAll().forEach(specialitySet::add);
        return specialitySet;
    }

    @Override
    public Speciality findById(Long id) {
        return specialtyReposiotry.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialtyReposiotry.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialtyReposiotry.delete(object);
    }

    @Override
    public void deleteAllById(Long id) {
        specialtyReposiotry.deleteById(id);
    }
}
