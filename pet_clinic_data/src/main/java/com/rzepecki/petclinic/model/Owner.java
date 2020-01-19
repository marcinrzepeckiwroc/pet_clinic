package com.rzepecki.petclinic.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Builder
    public Owner(Long id, @NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty String address,
                 @NotEmpty String city, String telephone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        if(pets != null){
            this.pets = pets;
        }
    }

    @Column(name = "address")
    @NotEmpty
    private String address;

    @Column(name = "city")
    @NotEmpty
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner") //mapowanie po polu owner z klay Pet, skasowanie ownera kasuje pet
    private Set<Pet> pets = new HashSet<>();

    public Pet getPet(String name){
        return getPet(name, false);
    }

    public Pet getPet(String name, boolean ignoreNew){
        name = name.toLowerCase();
        for(Pet pet: pets){
            if(!ignoreNew || !pet.isNew()){
                String compName = pet.getName();
                compName = compName.toLowerCase();
                if(compName.equals(name)){
                    return pet;
                }
            }
        }
        return null;
    }
}
