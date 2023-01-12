package com.sopra.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sopra.entity.TrainingName;
import com.sopra.entity.Trainingg;
import com.sopra.repository.TrainingNameRepo;
import com.sopra.service.TrainingNameService;

@Service
public class TrainingNameServiceImpl implements TrainingNameService {
	private TrainingNameRepo trainingNameRepo;

	public TrainingNameServiceImpl(TrainingNameRepo trainingNameRepo) {
		super();
		this.trainingNameRepo = trainingNameRepo;
	}

	@Override
	public TrainingName saveTrainingName(TrainingName trainingName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TrainingName> getAllTrainingName() {
		// TODO Auto-generated method stub
		return trainingNameRepo.findAll();
	}

}