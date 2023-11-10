package com.example.testcontainerdemo.controller;

import com.example.testcontainerdemo.model.dto.PetDto;
import com.example.testcontainerdemo.service.PetService;
import com.example.testcontainerdemo.util.TestDataLoader;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
class PetsControllerImplTest{
    @Autowired
    PetsController petsController;

    @Autowired
    PetService petService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    TestDataLoader testDataLoader;

    @Container
    @ServiceConnection
    private static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:latest");

    @BeforeEach
    void setup(){
        testDataLoader.loadTestData();
    }

    @AfterEach
    void teardown(){
        testDataLoader.deleteTestData();
    }

    @Test
    void testCreateNewPet_shouldCreatePet() throws Exception {
        PetDto requestDto = PetDto.builder()
                .name("Bobby the third")
                .breed("Bulldog")
                .age(14)
                .build();
        String newDogJson = objectMapper.writeValueAsString(requestDto);

        String actualResultJson = mockMvc.perform(post("/pets")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newDogJson))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        PetDto actualResponse = objectMapper.readValue(actualResultJson, PetDto.class);

        assertThat(actualResponse)
                .isNotNull()
                .isEqualTo(requestDto);
    }

    @Test
    void testGetAllPets_returnsAllPets() throws Exception {
        String actualResponseJson = mockMvc.perform(get("/pets"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        List<PetDto> actualResult = objectMapper.readValue(actualResponseJson, objectMapper.getTypeFactory().constructCollectionType(List.class, PetDto.class));

        assertThat(actualResult)
                .isNotNull()
                .hasSize(3);
    }
}
