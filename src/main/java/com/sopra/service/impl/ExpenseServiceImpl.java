package com.sopra.service.impl;

 

import java.util.ArrayList;
import java.util.List;

 

import org.springframework.stereotype.Service;

 

import com.sopra.entity.Expense;
import com.sopra.repository.ExpenseRepository;
import com.sopra.service.ExpenseService;

 

@Service
public class ExpenseServiceImpl implements ExpenseService {

 

    private ExpenseRepository expenseRepository;

 

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        super();
        this.expenseRepository = expenseRepository;
    }

 

    @Override
    public List<Expense> getAllExpense() {
        // TODO Auto-generated method stub
        List<Expense> l = new ArrayList<>();
        l = expenseRepository.findAll();

return l;
    }

 

    @Override
    public Expense saveExpense(Expense expense) {
        // TODO Auto-generated method stub

 

        return expenseRepository.save(expense);
    }

 

    @Override
    public Expense getExpenseById(Long id) {
        // TODO Auto-generated method stub
        return expenseRepository.findById(id).get();
    }

 

    @Override
    public Expense updateExpense(Expense existingexpense) {
        // TODO Auto-generated method stub
        return expenseRepository.save(existingexpense);
    }

 

    @Override
    public int sumrem() {

 

        return expenseRepository.sumrem();

 

    }

 

    @SuppressWarnings("unlikely-arg-type")
    @Override
    public List<Expense> findexpensebyyear(Integer year) {
        // TODO Auto-generated method stub
        List<Expense> l4 = new ArrayList<>();
        if (year.equals("All")) {
            l4 = expenseRepository.findAll();
        } else {
            l4 = expenseRepository.findexpensebyyear(year);
        }
        return l4;
    }

 

    @Override
    public int sumrem(Integer year) {
        // TODO Auto-generated method stub
        return expenseRepository.sumrem(year);
    }

 

}