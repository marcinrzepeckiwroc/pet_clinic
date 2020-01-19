package com.rzepecki.petclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

    @Builder
    public PetType(Long id, @NotEmpty String name) {
        super(id);
        this.name = name;
    }

    @Column(name = "name")
    @NotEmpty
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
