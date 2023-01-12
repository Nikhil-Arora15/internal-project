package com.sopra.service;

import java.util.List;

import com.sopra.entity.TrainingName;
import com.sopra.entity.Trainingg;

public interface TrainingNameService {
	TrainingName saveTrainingName(TrainingName trainingName);

	List<TrainingName> getAllTrainingName();

}