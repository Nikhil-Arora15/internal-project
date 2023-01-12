package com.sopra.service.impl;

 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

 

import org.springframework.stereotype.Service;

 

import com.sopra.entity.Amount;
import com.sopra.entity.Trainingg;
import com.sopra.repository.AmountRepository;
import com.sopra.service.AmountService;
@Service
public class AmountServiceImpl implements AmountService {

    private AmountRepository amountRepository;

 

    public AmountServiceImpl(AmountRepository amountRepository) {
        super();
        this.amountRepository = amountRepository;
    }

 

    @Override
    public List<Amount> getAllAmount() {
        // TODO Auto-generated method stub
         List<Amount> ll = new ArrayList<>();
            ll= amountRepository.findAll();

            Collections.sort(ll , new Comparator<Amount>() {

                public int compare(Amount o1, Amount o2) {
                        // TODO Auto-generated method stub
                        return(o1.getEmp_name().compareTo(o2.getEmp_name()));
                    }
                  });
            return ll;
    }

 

    @Override
    public Amount saveAmount(Amount amount) {
        // TODO Auto-generated method stub
        return amountRepository.save(amount) ;
    }

 

    @Override
    public Amount getAmountById(Long id) {
        // TODO Auto-generated method stub
        return amountRepository.findById(id).get();
    }

 

    @Override
    public Amount updateAmount(Amount amount) {
        // TODO Auto-generated method stub
        return null;
    }

 

    @Override
    public void deleteAmountById(Long id) {
        // TODO Auto-generated method stub

    }

 

    @Override
    public List<Amount> getAmountwithMonth(String month) {
        // TODO Auto-generated method stub
        List<Amount> l3 = new ArrayList<>();
        if(month.equals("All")) {
            l3= amountRepository.findAll();

        }
        else {
        l3= amountRepository.findamountbymonth(month);
        }
        return l3;

    }

 


}