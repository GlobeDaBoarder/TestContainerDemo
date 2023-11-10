package com.example.testcontainerdemo.service;

import com.example.testcontainerdemo.mapper.PetMapper;
import com.example.testcontainerdemo.model.dto.PetDto;
import com.example.testcontainerdemo.model.entity.PetEntity;
import com.example.testcontainerdemo.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService{
    private final PetRepository petRepository;
    private final PetMapper petMapper;

    @Override
    public List<PetDto> getAllPets() {
        return petRepository.findAll()
                .stream()
                .map(petMapper::toDto)
                .toList();
    }

    @Override
    public PetDto createPet(PetDto petDto) {
        PetEntity pet = petMapper.toEntity(petDto);

        pet = petRepository.save(pet);

        return petMapper.toDto(pet);
    }
}
