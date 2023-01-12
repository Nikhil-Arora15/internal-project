package com.sopra.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sopra.entity.Trainingg;
import com.sopra.repository.TraininggRepo;
import com.sopra.service.TraininggService;

@Service
public class TraininggServiceImpl implements TraininggService {

	private TraininggRepo traininggRepo;

	public TraininggServiceImpl(TraininggRepo traininggRepo) {
		super();
		this.traininggRepo = traininggRepo;
	}

	@Override
	public Trainingg saveTrainingg(Trainingg trainingg) {
		// TODO Auto-generated method stub
		return traininggRepo.save(trainingg);
	}

	@Override
	public List<Trainingg> getAllTrainingg() {
		List<Trainingg> l5 = new ArrayList<>();
		l5 = traininggRepo.findAll();

		return l5;
	}

	@Override
	public Trainingg getTraininggById(Long id) {
		// TODO Auto-generated method stub
		return traininggRepo.findById(id).get();
	}

	@Override
	public Trainingg updateTrainingg(Trainingg existingtrainingg) {
		// TODO Auto-generated method stub
		return traininggRepo.save(existingtrainingg);
	}

	@Override
	public List<Trainingg> findtraininggbytraining(String training) {
		// TODO Auto-generated method stub
		List<Trainingg> l3 = new ArrayList<>();
		if (training.equals("All")) {
			l3 = traininggRepo.findAll();
		} else {
			l3 = traininggRepo.findtraininggbytraining(training);
		}
		return l3;
	}

}