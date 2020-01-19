package com.rzepecki.petclinic.services;

import com.rzepecki.petclinic.model.Owner;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastName(String lastName);

}
