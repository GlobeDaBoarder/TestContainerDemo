package com.example.testcontainerdemo;

import com.example.testcontainerdemo.model.entity.PetEntity;
import com.example.testcontainerdemo.repository.PetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class TestContainerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestContainerDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PetRepository petRepository){
        return args -> {
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
        };
    }

}
