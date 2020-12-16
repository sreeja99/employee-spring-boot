package com.bridgelabz.employee.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.bridgelabz.employee.dto.EmployeePayrollDTO;

import lombok.Data;

@Entity
@Table(name="employee_payroll")
public @Data class EmployeePayrollData {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employeeId")
	private int employeeId;
	@Column(name="name")
	
	private String name;
	private long salary;
	private String gender;
	private LocalDate startDate;
	private String note;
	private String profilePic;
	
	@ElementCollection
	@CollectionTable(name="employee_department",joinColumns= @JoinColumn(name="id"))
	@Column(name="department")
	private List<String> departments;
	 
	public EmployeePayrollData() { }
	
	public EmployeePayrollData(int empID,EmployeePayrollDTO empPayrollDTO) {
		this.employeeId=empID;
		this.name = empPayrollDTO.name;
		this.salary = empPayrollDTO.salary;
		this.gender=empPayrollDTO.gender;
		this.startDate=empPayrollDTO.startDate;
		this.note=empPayrollDTO.note;
		this.profilePic=empPayrollDTO.profilePic;
		this.departments=empPayrollDTO.department;
	}
	public void updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		this.name = employeePayrollDTO.name;
		this.salary = employeePayrollDTO.salary;
		this.gender=employeePayrollDTO.gender;
		this.startDate=employeePayrollDTO.startDate;
		this.note=employeePayrollDTO.note;
		this.profilePic=employeePayrollDTO.profilePic;
		this.departments=employeePayrollDTO.department;	
	}
public EmployeePayrollData( EmployeePayrollDTO employeePayrollDTO) {
	this.updateEmployeePayrollData(employeePayrollDTO);
	}

	
	
	
}
