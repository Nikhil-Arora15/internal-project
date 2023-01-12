package com.sopra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sopra.entity.Expense;
import com.sopra.service.impl.ExpenseServiceImpl;

@Controller
public class ExpenseController {
	@Autowired
	private ExpenseServiceImpl expenseServiceImpl;

	public ExpenseController(ExpenseServiceImpl expenseServiceImpl) {
		super();
		this.expenseServiceImpl = expenseServiceImpl;
	}

	@GetMapping("/employee/contri/add")
	public String contri_addFrom(Model model) {
		Expense expense = new Expense();
		model.addAttribute("expense", expense);
		return "contri_add";
	}

	@PostMapping("/employee/contri")
	public String addExpense(Expense expense) {
		expense.setRemaining_amount(expense.getTotal_contri_amount() - expense.getExpenditure());
		expenseServiceImpl.saveExpense(expense);
		return "redirect:/employee/contri";
	}

	// update_contri own
	@GetMapping("/employee/contri/{id}")
	public String editEmployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("expense", expenseServiceImpl.getExpenseById(id));
		return "update_expense";
	}

	@PostMapping("/employee/contri/{id}")
	public String updateExpense(@PathVariable Long id, @ModelAttribute("expense") Expense expense, Model model) {

		Expense existingExpense = expenseServiceImpl.getExpenseById(id);
		// existingExpense.setId(id);
		existingExpense.setYear(expense.getYear());
		existingExpense.setMonths(expense.getMonths());
		existingExpense.setTotal_contri_amount(expense.getTotal_contri_amount());
		existingExpense.setExpenditure(expense.getExpenditure());
		existingExpense.setNotes(expense.getNotes());
		existingExpense.setRemaining_amount(expense.getTotal_contri_amount() - expense.getExpenditure());
		// existingExpense.setExpenditure(expense.getExpenditure());
		// existingEmployee.setLocation(employee.getLocation());
		// existingEmployee.setFactory(employee.getFactory());
		// existingEmployee.setMajor_area(employee.getMajor_area());
		// existingEmployee.setSkills(employee.getSkills());
		// save update student object
		expenseServiceImpl.updateExpense(existingExpense);
		// return "redirect:/monthlycontri";
		return "redirect:/employee/contri";

	}
	// till

	@GetMapping("/employee/contri")
	public String monthlyContri(Model model) {

		model.addAttribute("expense", expenseServiceImpl.getAllExpense());
		model.addAttribute("sumrem", expenseServiceImpl.sumrem());

		return "monthlycontri";
	}

	// contributed amount

	@GetMapping("/employee/contri/year/{year}")
	public String monthlycontriForm(@PathVariable Integer year, Model model) {

		model.addAttribute("expense", expenseServiceImpl.findexpensebyyear(year));
		model.addAttribute("sumrem", expenseServiceImpl.sumrem(year));
		model.addAttribute("y", year);

		return "monthlycontri";
	}

}