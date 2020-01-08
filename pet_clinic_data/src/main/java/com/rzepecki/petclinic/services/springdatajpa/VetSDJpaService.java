package com.rzepecki.petclinic.services.springdatajpa;

import com.rzepecki.petclinic.model.Vet;
import com.rzepecki.petclinic.repositories.SpecialtyReposiotry;
import com.rzepecki.petclinic.repositories.VetRepository;
import com.rzepecki.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {
    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vetSet = new HashSet<>();
        vetRepository.findAll().forEach(vetSet::add);
        return vetSet;
    }

    @Override
    public Vet findById(Long id) {
        Optional<Vet> optionalVet = vetRepository.findById(id);
        return optionalVet.orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteAllById(Long id) {
        vetRepository.deleteById(id);
    }
}
