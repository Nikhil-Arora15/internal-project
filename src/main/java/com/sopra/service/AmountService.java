package com.sopra.service;

 

import java.util.List;

 

import com.sopra.entity.Amount;

 

public interface AmountService {
    List<Amount> getAllAmount();    
    Amount saveAmount(Amount amount);

    Amount getAmountById(Long id);
    Amount updateAmount(Amount amount);

    void deleteAmountById(Long id);
    List<Amount> getAmountwithMonth(String month);

 

}