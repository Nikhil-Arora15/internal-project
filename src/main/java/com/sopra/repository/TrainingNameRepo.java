package com.sopra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.entity.TrainingName;

public interface TrainingNameRepo extends JpaRepository<TrainingName, Long> {

}