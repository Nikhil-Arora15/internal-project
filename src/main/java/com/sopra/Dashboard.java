package com.sopra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sopra.entity.Employee;
import com.sopra.repository.EmployeeRepository;

@SpringBootApplication
public class Dashboard implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Dashboard.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Employee student1 = new Employee("Reamesh","Singh","ramesh@gmail.com");
//		employeeRepository.save(student1);

//		Employee student2 = new Employee("Sanjay","yadav","sanjay@gmail.com");
//		employeeRepository.save(student2);
//		
//		Employee student3 = new Employee("Tony","Stark","tony@gmail.com");
//		employeeRepository.save(student3);

	}

}
