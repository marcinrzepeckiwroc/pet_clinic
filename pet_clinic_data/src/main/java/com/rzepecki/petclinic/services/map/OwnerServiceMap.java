package com.rzepecki.petclinic.services.map;

import com.rzepecki.petclinic.model.Owner;
import com.rzepecki.petclinic.model.Pet;
import com.rzepecki.petclinic.services.CrudService;
import com.rzepecki.petclinic.services.OwnerService;
import com.rzepecki.petclinic.services.PetService;
import com.rzepecki.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        if(object!=null){
            if(object.getPets()!=null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId()== null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("Pet Type is not set");
                    }

                    if(pet.getId() == null){
                       Pet savePet = petService.save(pet);
                       pet.setId(savePet.getId());
                    }
                });
            }
            return super.save(object);
        }else {
            return null;
        }
    }

    @Override
    public void deleteAllById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public List<Owner> findAllByLastName(String lastName) {
        //to do impl
        return null;
    }
}
