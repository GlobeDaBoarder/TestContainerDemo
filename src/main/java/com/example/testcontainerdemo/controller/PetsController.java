/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.0.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.testcontainerdemo.controller;

import com.example.testcontainerdemo.model.dto.PetDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "pets", description = "the pets API")
public interface PetsController {


    /**
     * POST /pets : Create a pet
     * Create a pet
     *
     * @param petDto Pet object that needs to be added to the store (required)
     * @return OK (status code 200)
     */
    @Operation(
        operationId = "createPet",
        summary = "Create a pet",
        description = "Create a pet",
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PetDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/pets",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
     ResponseEntity<PetDto> createPet(
        @Parameter(name = "Pet", description = "Pet object that needs to be added to the store", required = true) @Valid @RequestBody PetDto petDto
    );


    /**
     * GET /pets : Get all pets
     * Get all pets
     *
     * @return OK (status code 200)
     */
    @Operation(
        operationId = "getAllPets",
        summary = "Get all pets",
        description = "Get all pets",
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PetDto.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/pets",
        produces = { "application/json" }
    )
     ResponseEntity<List<PetDto>> getAllPets(
        
    );

}
