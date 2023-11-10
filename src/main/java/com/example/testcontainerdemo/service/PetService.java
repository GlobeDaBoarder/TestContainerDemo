package com.example.testcontainerdemo.service;

import com.example.testcontainerdemo.model.dto.PetDto;

import java.util.List;

public interface PetService {
    List<PetDto> getAllPets();

    PetDto createPet(PetDto petDto);
}
