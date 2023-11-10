package com.example.testcontainerdemo.repository;

import com.example.testcontainerdemo.model.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<PetEntity, Long>{

}
