package com.sopra.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sopra.entity.Employee;

// jpa repository has two parameters 1. type of repository and other is type of primary key	

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	@Query("SELECT u FROM Employee u WHERE u.status= ?1")
	List<Employee> findemployeebystatus(String status);

}
