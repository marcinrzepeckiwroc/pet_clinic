package com.rzepecki.petclinic.services.map;

import com.rzepecki.petclinic.model.Vet;
import com.rzepecki.petclinic.services.CrudService;
import com.rzepecki.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object);
    }

    @Override
    public void deleteAllById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
