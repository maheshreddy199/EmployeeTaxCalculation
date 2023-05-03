package com.tasks.in.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Tax {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Employee Id is mandatory")
	private long empId;
	
	@NotNull(message = "FirstName is mandatory")
	private String firstName;
	@NotNull(message = "LastName is mandatory")
	private String lastName;
	
	@NotNull(message = "Yearly salary is required")
	private long yearlySalary;
	
	@NotNull(message = "Tax amount is required")
	private long taxAmount;
	
	@NotNull(message = "Cess amount is required")
	private long cessAmount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getYearlySalary() {
		return yearlySalary;
	}

	public void setYearlySalary(long yearlySalary) {
		this.yearlySalary = yearlySalary;
	}

	public long getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(long taxAmount) {
		this.taxAmount = taxAmount;
	}

	public long getCessAmount() {
		return cessAmount;
	}

	public void setCessAmount(long cessAmount) {
		this.cessAmount = cessAmount;
	}

	public Tax(long id, @NotNull(message = "Employee Id is mandatory") long empId,
			@NotNull(message = "FirstName is mandatory") String firstName,
			@NotNull(message = "LastName is mandatory") String lastName,
			@NotNull(message = "Yearly salary is required") long yearlySalary,
			@NotNull(message = "Tax amount is required") long taxAmount,
			@NotNull(message = "Cess amount is required") long cessAmount) {
		this.id = id;
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearlySalary = yearlySalary;
		this.taxAmount = taxAmount;
		this.cessAmount = cessAmount;
	}

	public Tax() {

	}
	
	
	
}
