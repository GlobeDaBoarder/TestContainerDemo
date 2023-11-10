package com.example.testcontainerdemo.controller;

import com.example.testcontainerdemo.model.dto.PetDto;
import com.example.testcontainerdemo.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PetsControllerImpl implements PetsController {
    private final PetService petService;

    @Override
    public ResponseEntity<PetDto> createPet(PetDto petDto) {
        return ResponseEntity.ok(petService.createPet(petDto));
    }

    @Override
    public ResponseEntity<List<PetDto>> getAllPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }
}
