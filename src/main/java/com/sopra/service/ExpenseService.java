package com.sopra.service;

 

import java.util.List;

 

import com.sopra.entity.Expense;
import com.sopra.entity.Trainingg;

 

public interface ExpenseService {

 

    Expense saveExpense(Expense expense);

 

    List<Expense> getAllExpense();

 

    public int sumrem();

 

    public int sumrem(Integer year);

 

    Expense getExpenseById(Long id);

 

    Expense updateExpense(Expense existingexpense);

 

    List<Expense> findexpensebyyear(Integer year);

 

}