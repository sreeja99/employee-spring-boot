package com.bridgelabz.employee.model;

import java.time.LocalDate;
import java.util.List;

import com.bridgelabz.employee.dto.EmployeePayrollDTO;

import lombok.Data;

public @Data class EmployeePayrollData {
	private int employeeId;
	private String name;
	private long salary;
	private String gender;
	private LocalDate startDate;
	private String note;
	private String profilePic;
	private List<String> departments;
	 
	public EmployeePayrollData() { }
	public EmployeePayrollData(int empId,EmployeePayrollDTO empPayrollDTO) {
		this.employeeId=empId;
		this.updateEmployeePayrollData(empPayrollDTO);
	}
	private void updateEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		this.name = empPayrollDTO.name;
		this.salary = empPayrollDTO.salary;
		this.gender=empPayrollDTO.gender;
		this.startDate=empPayrollDTO.startDate;
		this.note=empPayrollDTO.note;
		this.profilePic=empPayrollDTO.profilePic;
		this.departments=empPayrollDTO.department;
		
	}
	
	
}
