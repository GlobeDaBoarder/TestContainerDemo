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
}
