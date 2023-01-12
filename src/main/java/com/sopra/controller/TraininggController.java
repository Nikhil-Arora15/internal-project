package com.sopra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sopra.entity.Expense;
import com.sopra.entity.Trainingg;
import com.sopra.service.TrainingNameService;
import com.sopra.service.impl.TrainingNameServiceImpl;
import com.sopra.service.impl.TraininggServiceImpl;

@Controller
public class TraininggController {
	private TraininggServiceImpl traininggServiceImpl;
	@Autowired
	private TrainingNameService trainingnameService;

	public TraininggController(TraininggServiceImpl traininggServiceImpl) {
		super();
		this.traininggServiceImpl = traininggServiceImpl;
	}

//    @GetMapping("/employee/training")
//    public String listTraining(Model model) {
//        model.addAttribute("trainingg", traininggServiceImpl.getAllTrainingg());
//        return "training";
//    }
//    
	@GetMapping("/employee/training")
	public String trainingg(Model model) {

		model.addAttribute("trainingg", traininggServiceImpl.getAllTrainingg());
		model.addAttribute("training_name", trainingnameService.getAllTrainingName());

		return "trainingg";
	}

	@GetMapping("/employee/addTraining")
	public String addTrainingFrom(Model model) {
		Trainingg trainingg = new Trainingg();
		model.addAttribute("trainingg", trainingg);
		model.addAttribute("training_name", trainingnameService.getAllTrainingName());
		return "addTraining";
	}

	@PostMapping("/employee/addTraining")
	public String addTrainingg(Trainingg trainingg) {
		// training.setRemaining_amount(training.getTotal_contri_amount() -
		// expense.getExpenditure());
		traininggServiceImpl.saveTrainingg(trainingg);
		return "redirect:/employee/training";
	}

	// update training button from here

	@GetMapping("/employee/updateTraining/{id}")
	public String training_updateForm(@PathVariable Long id, Model model) {
		model.addAttribute("trainingg", traininggServiceImpl.getTraininggById(id));
		return "training_update";
	}

	@PostMapping("/employee/updateTraining/{id}")
	public String updateTrainingg(@PathVariable Long id, @ModelAttribute("trainingg") Trainingg trainingg,
			Model model) {

		Trainingg existingTrainingg = traininggServiceImpl.getTraininggById(id);
		// existingExpense.setId(id);
		existingTrainingg.setEmp_id(trainingg.getEmp_id());
		existingTrainingg.setEmp_name(trainingg.getEmp_name());
		existingTrainingg.setTraining_name(trainingg.getTraining_name());
		existingTrainingg.setStatus(trainingg.getStatus());

		traininggServiceImpl.updateTrainingg(existingTrainingg);
		return "redirect:/employee/training";

	}

	@GetMapping("/employee/training/{training}")
	public String traininggForm(@PathVariable String training, Model model) {

		model.addAttribute("trainingg", traininggServiceImpl.findtraininggbytraining(training));
		model.addAttribute("t", training);
		model.addAttribute("training_name", trainingnameService.getAllTrainingName());
		return "trainingg";
	}

}