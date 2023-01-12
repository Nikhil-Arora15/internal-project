package com.sopra.entity;

 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

 

import org.hibernate.annotations.Table;

 

@Entity
@Table(appliesTo = "amount")
public class Amount {
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

    @Column(name = "month")
    private String month;

    @Column(name = "employee_id")
    private Integer emp_id;

    @Column(name = "employee_name")
    private String emp_name;

 


    @Column(name = "Contri_amount")
    private Long contri_amount;

 

    public Integer getYear() {
        return year;
    }

 

    public void setYear(Integer year) {
        this.year = year;
    }

 

    public String getMonth() {
        return month;
    }

 

    public void setMonth(String month) {
        this.month = month;
    }

 

    public Integer getEmp_id() {
        return emp_id;
    }

 

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

 

    public String getEmp_name() {
        return emp_name;
    }

 

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

 

    public Long getContri_amount() {
        return contri_amount;
    }

 

    public void setContri_amount(Long contri_amount) {
        this.contri_amount = contri_amount;
    }

 

    public Amount(Long id, Integer year, String month, Integer emp_id, String emp_name, Long contri_amount) {
        super();
        this.id = id;
        this.year = year;
        this.month = month;
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.contri_amount = contri_amount;
    }

 

    public Amount() {
        super();
        // TODO Auto-generated constructor stub
    }

 

    

 

}