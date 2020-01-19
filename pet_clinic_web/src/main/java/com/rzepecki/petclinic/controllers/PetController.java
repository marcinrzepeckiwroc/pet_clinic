package com.rzepecki.petclinic.controllers;

import com.rzepecki.petclinic.model.Owner;
import com.rzepecki.petclinic.model.Pet;
import com.rzepecki.petclinic.model.PetType;
import com.rzepecki.petclinic.services.OwnerService;
import com.rzepecki.petclinic.services.PetService;
import com.rzepecki.petclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private static final String VIEWS_PET_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";
    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }


    @ModelAttribute("types")
    public Set<PetType> populatePetType(){
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId){
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
    }

    @GetMapping("/pets/new") //otwiera okno - pobiera dane z formularza
    public String initCreationForm(Owner owner, Model model){
        System.out.println("get mapping pets/new");
        Pet pet = new Pet();
        owner.getPets().add(pet);
        pet.setOwner(owner);
        model.addAttribute("pet",pet);
        return VIEWS_PET_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/new")
    public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult result, ModelMap model) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null){
            result.rejectValue("name", "duplicate", "already exists");
        }
        owner.getPets().add(pet);
        if (result.hasErrors()) {
            model.put("pet", pet);
            return VIEWS_PET_CREATE_OR_UPDATE_FORM;
        } else {
            petService.save(pet);

            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping("/pets/{petId}/edit")
    public String initUpdateForm(@PathVariable("petId") Long petId, Model model){
        System.out.println("GetMaping pet update");
        model.addAttribute("pet", petService.findById(petId));
        return VIEWS_PET_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/{petId}/edit")
    public String processUpdateForm(@Valid Pet pet, BindingResult bindingResult, Owner owner, Model model){
        System.out.println("PostMaping update pet");
        if(bindingResult.hasErrors()){
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return VIEWS_PET_CREATE_OR_UPDATE_FORM;
        }else {
            owner.getPets().add(pet);
            petService.save(pet);
            return "redirect:/owners/"+owner.getId();
        }
    }

}
