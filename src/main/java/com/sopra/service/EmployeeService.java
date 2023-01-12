package com.sopra.service;

import java.util.List;

import com.sopra.entity.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployee();

	Employee saveEmployee(Employee employee);

	Employee getEmployeeById(Long id);

	Employee updateEmployee(Employee employee);

	void deleteEmployeeById(Long id);

	List<Employee> getEmployeewithStatus(String status);

}
