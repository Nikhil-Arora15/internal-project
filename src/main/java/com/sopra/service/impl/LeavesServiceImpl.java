package com.sopra.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sopra.entity.Employee;
import com.sopra.entity.Leaves;
import com.sopra.repository.LeavesRepository;

import com.sopra.service.LeavesService;

@Service
public class LeavesServiceImpl implements LeavesService {

	private LeavesRepository leavesRepository;

	public LeavesServiceImpl(LeavesRepository leavesRepository) {
		super();
		this.leavesRepository = leavesRepository;
	}

	@Override
	public List<Leaves> getAllLeaves() {
		// TODO Auto-generated method stub
		List<Leaves> l = new ArrayList<>();
		l = leavesRepository.findAll();
		return l;
	}

	@Override
	public Leaves saveLeaves(Leaves leaves) {
		// TODO Auto-generated method stub
		return leavesRepository.save(leaves);
	}

	@Override
	public Leaves getLeavesById(Long id) {
		// TODO Auto-generated method stub
		return leavesRepository.findById(id).get();
	}

	@Override
	public Leaves updateLeaves(Leaves leaves) {
		// TODO Auto-generated method stub
		return leavesRepository.save(leaves);
	}

	@Override
	public List<Leaves> getLeaveswithMonth(String month) {
		// TODO Auto-generated method stub
		List<Leaves> l = new ArrayList<>();
		if (month.equals("All")) {
			l = leavesRepository.findAll();
		} else {
			l = leavesRepository.findleavesbymonth(month);
		}
		return l;
	}

	@Override
	public float sumleaves() {
		return leavesRepository.sumleaves();
	}

	@Override
	public float sumleaves(String month) {
		if (month.equals("All")) {
			return leavesRepository.sumleaves();
		} else {
			try {
				return leavesRepository.sumleaves(month);
			} catch (Exception e) {

				return 0;
				// TODO: handle exception
			}
		}

	}

	@Override
	public void deleteLeaveById(Long id) {
		// TODO Auto-generated method stub
		leavesRepository.deleteById(id);

	}

}
