package com.sopra.repository;

 

import java.util.List;

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

 

import com.sopra.entity.Amount;
import com.sopra.entity.Expense;

 

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
      @Query(value="select sum(remaining_amount) FROM Expense")
      public int sumrem();
      @Query("SELECT u FROM Expense u WHERE u.year= ?1")
      List<Expense> findexpensebyyear(Integer year);

    @Query(value = "select sum(remaining_amount) FROM com.sopra.entity.Expense where year=?1 AND year IS NOT NULL")
    public int sumrem(Integer year);
}