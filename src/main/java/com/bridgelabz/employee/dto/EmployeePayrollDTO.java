package com.bridgelabz.employee.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class EmployeePayrollDTO {
	
	
	@NotEmpty(message = "Employee name Invalid")
	public String name;
	
	@Min(value=500,message="Min Wage should be more than 500")
	public long salary;
	
	public EmployeePayrollDTO(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeePayrollDTO [name=" + name + ", salary=" + salary + "]";
	}
	
}
