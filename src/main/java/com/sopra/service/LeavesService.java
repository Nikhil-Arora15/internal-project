package com.sopra.service;

import java.util.List;

import com.sopra.entity.Employee;
import com.sopra.entity.Leaves;

public interface LeavesService {

	List<Leaves> getAllLeaves();

	Leaves saveLeaves(Leaves leaves);

	Leaves getLeavesById(Long id);

	Leaves updateLeaves(Leaves leaves);

	void deleteLeaveById(Long id);

	List<Leaves> getLeaveswithMonth(String month);

	public float sumleaves();

	public float sumleaves(String month);

}