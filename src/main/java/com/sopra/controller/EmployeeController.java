package com.sopra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sopra.entity.Employee;
import com.sopra.service.EmployeeService;
import com.sopra.service.impl.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	@Autowired

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/employee")
	public String listEmployees(Model model) {
		model.addAttribute("employee", employeeService.getAllEmployee());
		return "employee";
	}

	@GetMapping("/employee/new")
	public String createEmployeeFrom(Model model) {

		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "create_employee";
	}

	@PostMapping("/employee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employee";
	}

	@GetMapping("/employee/calendar")
	public String Calendar(Model model) {

		return "index";
	}

	@GetMapping("/employee/edit/{id}")
	public String editEmployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit-employee";
	}

	@GetMapping("/employee/status/{status}")
	public String editEmployeeForm(@PathVariable String status, Model model) {

		model.addAttribute("employee", employeeService.getEmployeewithStatus(status));
		model.addAttribute("s", status);
		return "employee";
	}

	@PostMapping("/employee/{id}")
	public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee, Model model) {

		Employee existingEmployee = employeeService.getEmployeeById(id);
		existingEmployee.setId(id);
		existingEmployee.setEmp_id(employee.getEmp_id());
		existingEmployee.setEmp_name(employee.getEmp_name());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setLocation(employee.getLocation());
		existingEmployee.setFactory(employee.getFactory());
		existingEmployee.setMajor_area(employee.getMajor_area());
		existingEmployee.setSkills(employee.getSkills());
		existingEmployee.setStatus(employee.getStatus());
		existingEmployee.setStart_date(employee.getStart_date());
		existingEmployee.setEnd_date(employee.getEnd_date());

		// save update student object
		employeeService.updateEmployee(existingEmployee);
		return "redirect:/employee";

	}
	// contriadd

//	@GetMapping("/employee/contri/add")
//	public String contri_addFrom(Model model) {
//
//		Expense expense = new Expense();
//		model.addAttribute("expense", expense);
//		return "contri_add";
//	}

	@GetMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employee";
	}
}
