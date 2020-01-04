package com.rzepecki.petclinic.bootstrap;

import com.rzepecki.petclinic.model.Owner;
import com.rzepecki.petclinic.model.Vet;
import com.rzepecki.petclinic.services.OwnerService;
import com.rzepecki.petclinic.services.PetService;
import com.rzepecki.petclinic.services.VetService;
import com.rzepecki.petclinic.services.map.OwnerServiceMap;
import com.rzepecki.petclinic.services.map.PetServiceMap;
import com.rzepecki.petclinic.services.map.VetServiceMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Michał");
        owner1.setLastName("Kłoś");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Daniel");
        owner2.setLastName("Lasik");

        ownerService.save(owner2);

        System.out.println("Loaded owner...");

        Vet vet =new Vet();
        vet.setFirstName("Doktorek");
        vet.setLastName("Psi");

        vetService.save(vet);

        System.out.println("Loaded vet...");

    }
}
