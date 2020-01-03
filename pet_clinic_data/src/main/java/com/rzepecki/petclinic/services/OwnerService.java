package com.rzepecki.petclinic.services;

import com.rzepecki.petclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
