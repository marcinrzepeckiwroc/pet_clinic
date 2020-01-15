package com.rzepecki.petclinic.services;

import com.rzepecki.petclinic.model.Owner;
import org.springframework.stereotype.Service;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
