package com.rzepecki.petclinic.repositories;

import com.rzepecki.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerReposiotry extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

}
