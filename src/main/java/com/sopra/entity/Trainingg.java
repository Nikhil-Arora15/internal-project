package com.sopra.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "trainingg")
public class Trainingg {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "emp_id", nullable = false)
	private String emp_id;

	@Column(name = "emp_name")
	private String emp_name;

	@Column(name = "training_name")
	private String training_name;

	@Column(name = "status")
	private String status;

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public Trainingg(Long id, String emp_id, String emp_name, String training_name, String status) {
		super();
		this.id = id;
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.training_name = training_name;
		this.status = status;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getTraining_name() {
		return training_name;
	}

	public void setTraining_name(String training_name) {
		this.training_name = training_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Trainingg() {
		super();
		// TODO Auto-generated constructor stub
	}

}