package com.example.openapigeneratordemo.service;

import generated.pet.api.PetsApiDelegate;
import generated.pet.model.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PetServiceImpl implements PetService{
    // some repository dependency here

    private final List<Pet> petList = new ArrayList<>(Arrays.asList(
            new Pet().name("pet1").breed("breed1").age(1),
            new Pet().name("pet2").breed("breed2").age(2),
            new Pet().name("pet3").breed("breed3").age(3)
    ));

    @Override
    public List<Pet> getAllPets() {
        return petList;
    }

    @Override
    public Pet createPet(Pet pet) {
        petList.add(pet);
        return pet;
    }
}
