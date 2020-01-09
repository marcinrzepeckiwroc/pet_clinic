package com.rzepecki.petclinic.bootstrap;

import com.rzepecki.petclinic.model.*;
import com.rzepecki.petclinic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final SpecialitiesService specialitiesService;
    private final VisitService visitService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService, SpecialitiesService specialitiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count==0){
            loadData();

        }

    }

    private void loadData() {
        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");

        Speciality saveRadiology = specialitiesService.save(radiology);
        Speciality saveDentist = specialitiesService.save(dentistry);
        Speciality saveSurgery = specialitiesService.save(surgery);

        PetType petType = new PetType();
        petType.setName("dog");
        PetType petType1 = new PetType();
        petType1.setName("cat");
        PetType saveDog = petTypeService.save(petType);
        PetType saveCat = petTypeService.save(petType1);

        System.out.println();

        Owner owner1 = new Owner();
        owner1.setFirstName("Michał");
        owner1.setLastName("Kłoś");
        owner1.setAddress("hanki");
        owner1.setCity("Kalisz");
        owner1.setTelephone("+4854566545");

        Pet owner1Pet = new Pet();
        owner1Pet.setPetType(saveDog);
        owner1Pet.setOwner(owner1);
        owner1Pet.setBirthDate(LocalDate.now());
        owner1Pet.setName("Dogi");
        owner1.getPets().add(owner1Pet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Daniel");
        owner2.setLastName("Lasik");
        owner2.setCity("Wroclaw");
        owner2.setAddress("Aleja");
        owner2.setTelephone("+4854566545");

        Pet owner2Pet = new Pet();
        owner2Pet.setPetType(saveCat);
        owner2Pet.setOwner(owner2);
        owner2Pet.setBirthDate(LocalDate.now());
        owner2Pet.setName("Catiii");
        owner2.getPets().add(owner2Pet);


        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(owner2Pet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("wizyta kota");

        visitService.save(catVisit);

        System.out.println("Loaded owner...");

        Vet vet =new Vet();
        vet.setFirstName("Doktorek");
        vet.setLastName("Psi");
        vet.getSpecialities().add(saveSurgery);

        vetService.save(vet);

        Vet vet1 =new Vet();
        vet1.setFirstName("Doktor");
        vet1.setLastName("koci");
        vet1.getSpecialities().add(saveDentist);

        vetService.save(vet1);



        System.out.println("Loaded vet...");
    }
}
