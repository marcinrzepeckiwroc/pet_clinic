package com.rzepecki.petclinic.services.map;

import com.rzepecki.petclinic.model.Pet;
import com.rzepecki.petclinic.services.CrudService;
import com.rzepecki.petclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public void deleteAllById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
