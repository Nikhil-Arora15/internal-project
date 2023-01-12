package com.sopra.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(appliesTo = "leaves")
public class Leaves {
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "emp_id", nullable = false)
	private String emp_id;

	@Column(name = "emp_name", nullable = false)
	private String emp_name;

	@Column(name = "month", nullable = false)
	private String month;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "start_date")
	private java.util.Date start_date;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "end_date")
	private java.util.Date end_date;

	@Column(name = "no_days")
	private Float no_days;

	@Column(name = "status")
	private String status;

	@Column(name = "reason")
	private String reason;

//	@ManyToOne
//	@JoinColumn(name="id", nullable=false)
//	private Employee employee;

	public String getEmp_id() {
		return emp_id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Leaves() {
		super();
		// TODO Auto-generated constructor stub
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

	public java.util.Date getStart_date() {
		return start_date;
	}

	public void setStart_date(java.util.Date start_date) {
		this.start_date = start_date;
	}

	public java.util.Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(java.util.Date end_date) {
		this.end_date = end_date;
	}

	public Float getNo_days() {
		return no_days;
	}

	public void setNo_days(Float no_days) {
		this.no_days = no_days;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Leaves [id=" + id + ", emp_id=" + emp_id + ", emp_name=" + emp_name + ", start_date=" + start_date
				+ ", end_date=" + end_date + ", no_days=" + no_days + ", status=" + status + ", reason=" + reason + "]";
	}

}
