package com.rzepecki.petclinic.services.springdatajpa;

import com.rzepecki.petclinic.model.Owner;
import com.rzepecki.petclinic.repositories.OwnerReposiotry;
import com.rzepecki.petclinic.repositories.PetRepository;
import com.rzepecki.petclinic.repositories.PetTypesReposiotry;
import com.rzepecki.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerReposiotry ownerReposiotry;
    private final PetRepository petRepository;
    private final PetTypesReposiotry petTypesReposiotry;

    public OwnerSDJpaService(OwnerReposiotry ownerReposiotry,
                             PetRepository petRepository,
                             PetTypesReposiotry petTypesReposiotry) {
        this.ownerReposiotry = ownerReposiotry;
        this.petRepository = petRepository;
        this.petTypesReposiotry = petTypesReposiotry;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerReposiotry.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerReposiotry.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        Optional<Owner> optionalOwner = ownerReposiotry.findById(id);
        return optionalOwner.orElse(null);
        //tak samo jak
//        if(optionalOwner.isPresent()){
//            return optionalOwner.get();
//        }else {
//            return null;
//        }
    }

    @Override
    public Owner save(Owner object) {
        return ownerReposiotry.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerReposiotry.delete(object);
    }

    @Override
    public void deleteAllById(Long id) {
        ownerReposiotry.deleteById(id);
    }
}
