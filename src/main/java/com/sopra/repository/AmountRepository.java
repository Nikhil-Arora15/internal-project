package com.sopra.repository;

 

import java.util.List;

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

 

import com.sopra.entity.Amount;

 

public interface AmountRepository extends JpaRepository<Amount, Long>{

 

    
    @Query("SELECT u FROM Amount u WHERE u.month= ?1 AND year=2023")
    List<Amount> findamountbymonth(String month);

 

}