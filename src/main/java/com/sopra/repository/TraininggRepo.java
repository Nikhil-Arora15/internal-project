package com.sopra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sopra.entity.Amount;
import com.sopra.entity.Trainingg;

public interface TraininggRepo extends JpaRepository<Trainingg, Long> {

	// List<Trainingg> findtraininggwithtraining(String training);

	// List<Trainingg> findtraininggbytraining(String training);
	@Query("SELECT u FROM Trainingg u WHERE u.training_name=?1")
	List<Trainingg> findtraininggbytraining(String training);

}