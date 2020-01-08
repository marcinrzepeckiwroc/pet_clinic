package com.rzepecki.petclinic.services.map;

import com.rzepecki.petclinic.model.Visit;
import com.rzepecki.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {


    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteAllById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet()==null || visit.getPet().getOwner() ==null || visit.getPet().getId() == null){
            throw new RuntimeException("invalid visit");
        }else {
            return super.save(visit);
        }

    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
