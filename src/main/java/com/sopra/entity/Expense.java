package com.sopra.entity;

 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

 

import org.hibernate.annotations.Table;

 

@Entity
@Table(appliesTo = "expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

 

    public Long getId() {
        return id;
    }

 

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "year")
    private Integer year;

    @Column(name = "months", nullable = false)
    private String months;

 

    

 

    @Column(name = "total_contri_amount")
    private Integer total_contri_amount;

 

    @Column(name = "expenditure")
    private Integer expenditure;

 

    @Column(name = "remaining_amount")
    private Integer remaining_amount;

 

    @Column(name = "notes")
    private String notes;

 

    public Integer getYear() {
        return year;
    }

 

    public void setYear(Integer year) {
        this.year = year;
    }

 

    public String getMonths() {
        return months;
    }

 

    public void setMonths(String months) {
        this.months = months;
    }

 

    public Integer getTotal_contri_amount() {
        return total_contri_amount;
    }

 

    public void setTotal_contri_amount(Integer total_contri_amount) {
        this.total_contri_amount = total_contri_amount;
    }

 

    public Integer getExpenditure() {
        return expenditure;
    }

 

    public void setExpenditure(Integer expenditure) {
        this.expenditure = expenditure;
    }

 

    public Integer getRemaining_amount() {
        return remaining_amount;
    }

 

    public void setRemaining_amount(Integer remaining_amount) {
        this.remaining_amount = remaining_amount;
    }

 

    public String getNotes() {
        return notes;
    }

 

    public void setNotes(String notes) {
        this.notes = notes;
    }

 

    public Expense(Integer year, String months, Integer total_contri_amount, Integer expenditure,
            Integer remaining_amount, String notes) {
        super();
        this.year = year;
        this.months = months;
        this.total_contri_amount = total_contri_amount;
        this.expenditure = expenditure;
        this.remaining_amount = remaining_amount;
        this.notes = notes;
    }

 

    public Expense() {
        super();
        // TODO Auto-generated constructor stub
    }

 

    
}