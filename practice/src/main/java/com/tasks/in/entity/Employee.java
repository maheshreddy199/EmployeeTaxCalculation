package com.tasks.in.entity;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public class Employee {
	
	@NotBlank(message = "FirstName is mandatory")
	private String firstName;
	@NotNull(message = "LastName is mandatory")
	private String lastName;
	@NotNull(message = "Email is  mandatory")
	@Column(unique=true)
	@Email
	private String email;
	@NotNull(message = "Phone number is not mandatory")
	private String phoneNumber;
	
	@NotNull(message = "Please enter a valid date format")
	private String dateOfJoining;
	
	@Positive(message = "Salary should be positive")
	private long salary;



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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Employee( @NotNull(message = "FirstName is mandatory") String firstName,
			@NotNull(message = "LastName is mandatory") String lastName,
			@NotNull(message = "Email is not mandatory") @Email String email,
			@NotNull(message = "Phone number is not mandatory") String phoneNumber,
			@NotNull(message = "Please enter a valid date format") String dateOfJoining,
			@Positive(message = "Salary should be positive") long salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfJoining = dateOfJoining;
		this.salary = salary;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", dateOfJoining=" + dateOfJoining + ", salary=" + salary + "]";
	}
	
	
	
}

