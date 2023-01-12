package com.sopra.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sopra.entity.Employee;
import com.sopra.entity.Expense;
import com.sopra.entity.Leaves;
import com.sopra.service.EmployeeService;
import com.sopra.service.LeavesService;

@Controller
public class LeavesController {
	DateFormat monthFormat = null;
	String month = null;
	@Autowired
	private LeavesService leavesService;
	@Autowired
	private EmployeeService employeeService;

	public LeavesController() {
		super();
//		this.leavesService = leavesService;
//		this.employeeService=employeeService;
	}

	@GetMapping("/leaves")
	public String listEmployees(Model model) {
		model.addAttribute("leaves", leavesService.getAllLeaves());
		model.addAttribute("sumleave", leavesService.sumleaves());
		return "leaves";
	}

	@GetMapping("/leaves/new")
	public String createLeavesFrom(Model model) {

		Leaves leaves = new Leaves();

		model.addAttribute("leaves", leaves);
		model.addAttribute("employee", employeeService.getAllEmployee());
		return "create_leaves";
	}

	@PostMapping("/leaves")
	public String saveLeaves(@ModelAttribute("leaves") Leaves leaves) {
		monthFormat = new SimpleDateFormat("MMMM");
		month = monthFormat.format(leaves.getStart_date());
		leaves.setMonth(month);
		Date d = leaves.getStart_date();
		Date date = new Date();
		if (d.compareTo(date) < -1) {
			return "Error in Start Date";
		}
		if (leaves.getEnd_date().compareTo(leaves.getStart_date()) < 0) {
			return "error";
		} else {
			leavesService.saveLeaves(leaves);
			return "redirect:/leaves";
		}
	}

	@GetMapping("/leaves/edit/{id}")
	public String editEmployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("leaves", leavesService.getLeavesById(id));
		return "edit-leaves";
	}

	@PostMapping("/leaves/edit/{id}")
	public String updateEmployee(@PathVariable Long id, @ModelAttribute("leaves") Leaves leaves, Model model) {

		Leaves existingLeave = leavesService.getLeavesById(id);
		existingLeave.setId(id);
		existingLeave.setEmp_id(leaves.getEmp_id());
		existingLeave.setEmp_name(leaves.getEmp_name());

		existingLeave.setStart_date(leaves.getStart_date());
		monthFormat = new SimpleDateFormat("MMMM");
		month = monthFormat.format(leaves.getStart_date());
		existingLeave.setMonth(month);
		existingLeave.setEnd_date(leaves.getEnd_date());
		existingLeave.setNo_days(leaves.getNo_days());
		existingLeave.setStatus(leaves.getStatus());
		existingLeave.setReason(leaves.getReason());

		// save update student object
		leavesService.updateLeaves(existingLeave);
		return "redirect:/leaves";

	}

	@GetMapping("/leaves/month/{month}")
	public String editLeaveForm(@PathVariable String month, Model model) {

		model.addAttribute("leaves", leavesService.getLeaveswithMonth(month));
		model.addAttribute("sumleaves", leavesService.sumleaves(month));
		model.addAttribute("month", month);

		return "leaves";
	}

	@GetMapping("/leaves/{id}")
	public String deleteLeave(@PathVariable Long id) {
		leavesService.deleteLeaveById(id);
		return "redirect:/leaves";
	}
//	@GetMapping("/employee/calendar")
//	public String Calendar(Model model) {
//
//		return "index";
//	}

//	@GetMapping("/employee/edit/{id}")
//	public String editEmployeeForm(@PathVariable Long id, Model model) {
//		model.addAttribute("employee", employeeService.getEmployeeById(id));
//		return "edit-employee";
//	}

//	@PostMapping("/employee/{id}")
//	public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee, Model model) {
//
//		Employee existingEmployee = employeeService.getEmployeeById(id);
//		existingEmployee.setId(id);
//		existingEmployee.setEmp_id(employee.getEmp_id());
//		existingEmployee.setEmp_name(employee.getEmp_name());
//		existingEmployee.setEmail(employee.getEmail());
//		existingEmployee.setLocation(employee.getLocation());
//		existingEmployee.setFactory(employee.getFactory());
//		existingEmployee.setMajor_area(employee.getMajor_area());
//		existingEmployee.setSkills(employee.getSkills());
//		// save update student object
//		employeeService.updateEmployee(existingEmployee);
//		return "redirect:/employee";
//
//	}
	// contriadd

//	@GetMapping("/employee/contri/add")
//	public String contri_addFrom(Model model) {
//
//		Expense expense = new Expense();
//		model.addAttribute("expense", expense);
//		return "contri_add";
//	}

//	@GetMapping("/employee/{id}")
//	public String deleteEmployee(@PathVariable Long id) {
//		employeeService.deleteEmployeeById(id);
//		return "redirect:/employee";
//	}
}
