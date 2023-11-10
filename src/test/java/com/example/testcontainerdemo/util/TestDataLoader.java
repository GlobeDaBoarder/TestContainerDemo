package com.example.testcontainerdemo.util;

import com.example.testcontainerdemo.model.entity.PetEntity;
import com.example.testcontainerdemo.repository.PetRepository;
import com.example.testcontainerdemo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class TestDataLoader {
    @Autowired
    PetRepository petRepository;

    public void loadTestData(){
        PetEntity petEntity1 = PetEntity.builder()
                .name("Bobby")
                .breed("Bulldog")
                .age(2)
                .build();

        PetEntity petEntity2 = PetEntity.builder()
                .name("Lassie")
                .breed("Collie")
                .age(3)
                .build();

        PetEntity petEntity3 = PetEntity.builder()
                .name("Rex")
                .breed("German Shepherd")
                .age(4)
                .build();

        petRepository.saveAll(Arrays.asList(petEntity1, petEntity2, petEntity3));
    }

    public void deleteTestData() {
        petRepository.deleteAll();
    }
}
