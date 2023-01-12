package com.sopra.controller;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

 

import com.sopra.entity.Amount;
import com.sopra.service.impl.AmountServiceImpl;
@Controller
public class AmountController {


    //private ExpenseServiceImpl expenseServiceImpl;
    @Autowired
    private AmountServiceImpl amountServiceImpl;

 

    public AmountController() {
        super();
        //this.amountServiceImpl = amountServiceImpl;
    }

    @GetMapping("/employee/contri/amount/view")
    public String listAmount(Model model) {
    model.addAttribute("amount", amountServiceImpl.getAllAmount());
        return "viewAmount";
    }

    @GetMapping("/employee/contri/amount")
    public String contri_addamountFrom(Model model) {
        Amount amount = new Amount();
        model.addAttribute("amount", amount);
        return "addContriAmount";
    }
//    @GetMapping("/employee/contri/amount")
//    public String addContriAmountFrom(Model model) {
//        Amount amount = new Amount();
//        model.addAttribute("amount", amount);
//        return "viewAmount";
//    }
    @PostMapping("/employee/contri/amount")
    public String saveAmount(@ModelAttribute("amount") Amount amount) {
        amountServiceImpl.saveAmount(amount);
        return "redirect:/employee/contri/amount/view";
    }

    @GetMapping("/employee/contri/amount/view/{month}")
    public String viewAmountForm(@PathVariable String month, Model model) {

 

 

        model.addAttribute("amount", amountServiceImpl.getAmountwithMonth(month));
        model.addAttribute("m",month);
        return "viewAmount";
    }

 

}