package com.example.testcontainerdemo.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import lombok.Builder;

import java.util.Objects;

/**
 * Pet object
 */

@Schema(name = "Pet", description = "Pet object")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Builder
public record PetDto(
        String name,
        String breed,
        Integer age) {
}

