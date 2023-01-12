package com.sopra.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "emp_id", nullable = false)
	private String emp_id;

	@Column(name = "emp_name")
	private String emp_name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "email")
	private String email;
	@Column(name = "location")
	private String location;

	@Column(name = "factory")
	private String factory;

	@Column(name = "major_area")
	private String major_area;

	@Column(name = "skills")
	private String skills;
	@Column(name = "status")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee(String status) {
		super();
		this.status = status;
	}

	@Column(name = "start_date")
	private String start_date;
	@Column(name = "end_date")
	private String end_date;

	public Employee(Long id, String emp_id, String emp_name, String email, String location, String factory,
			String major_area, String skills, String start_date, String end_date) {
		super();
		this.id = id;
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.email = email;
		this.location = location;
		this.factory = factory;
		this.major_area = major_area;
		this.skills = skills;
		this.start_date = start_date;
		this.end_date = end_date;
	}

//	
//	@OneToMany(mappedBy="leave")
//    private Set<Leaves> leaves;

	public String getEmp_id() {
		return emp_id;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getMajor_area() {
		return major_area;
	}

	public void setMajor_area(String major_area) {
		this.major_area = major_area;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

//	public Set<Leaves> getLeaves() {
//		return leaves;
//	}
//
//	public void setLeaves(Set<Leaves> leaves) {
//		this.leaves = leaves;
//	}

}
