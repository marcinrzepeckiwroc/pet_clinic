package com.rzepecki.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass //dziedziczone atrybuty sa trwale  (stosowana do encji i klas ktore sa dziedziczone)
public class Person extends BaseEntity {

    public Person(Long id, @NotEmpty String firstName, @NotEmpty String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Column(name = "first_name")
    @NotEmpty
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty
    private String lastName;


}
