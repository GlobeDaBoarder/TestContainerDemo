package com.example.testcontainerdemo.mapper;


import com.example.testcontainerdemo.model.dto.PetDto;
import com.example.testcontainerdemo.model.entity.PetEntity;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {

    public PetDto toDto(PetEntity petEntity){
        return PetDto.builder()
                .name(petEntity.getName())
                .breed(petEntity.getBreed())
                .age(petEntity.getAge())
                .build();
    }

    public PetEntity toEntity(PetDto petDto){
        return PetEntity.builder()
                .name(petDto.name())
                .breed(petDto.breed())
                .age(petDto.age())
                .build();
    }
}
