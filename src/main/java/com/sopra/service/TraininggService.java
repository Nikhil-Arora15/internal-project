package com.sopra.service;

import java.util.List;

import com.sopra.entity.Expense;
import com.sopra.entity.Trainingg;

public interface TraininggService {

	Trainingg saveTrainingg(Trainingg trainingg);

	List<Trainingg> getAllTrainingg();

	// public int sumrem();

	Trainingg getTraininggById(Long id);

	Trainingg updateTrainingg(Trainingg existingtrainingg);

	List<Trainingg> findtraininggbytraining(String training);

}