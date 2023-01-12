package com.sopra.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.sopra.entity.Employee;
import com.sopra.repository.EmployeeRepository;
import com.sopra.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		List<Employee> l = new ArrayList<>();
		l = employeeRepository.findAll();
		return l;
	}

	@Override
	public List<Employee> getEmployeewithStatus(String status) {
		// TODO Auto-generated method stub
		List<Employee> l = new ArrayList<>();
		if (status.equals("All")) {
			l = employeeRepository.findAll();
		} else {
			l = employeeRepository.findemployeebystatus(status);
		}
		return l;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);

	}
}
