package com.bridgelabz.employee.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.ToString;

public @ToString class EmployeePayrollDTO {
	
	
	@NotEmpty(message="employee name cannot be null")
	@Pattern(regexp = "^[A-Z]{1}[A-Za-z\\s]{2,}$", message = "Employee name invalid")
	public String name;
	
	@Min(value=500,message="Min Wage should be more than 500")
	public long salary;
	
	public EmployeePayrollDTO(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}
	public String gender;

	public LocalDate startDate;

	public String note;

	public String profilePic;

	public List<String> department;


	
	
}
