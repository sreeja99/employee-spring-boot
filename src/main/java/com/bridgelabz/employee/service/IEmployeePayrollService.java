package com.bridgelabz.employee.service;

import java.util.List;

import com.bridgelabz.employee.dto.EmployeePayrollDTO;
import com.bridgelabz.employee.model.EmployeePayrollData;

public interface IEmployeePayrollService {
	List<EmployeePayrollData> getEmployeePayrollData();
	
	EmployeePayrollData getEmployeePayrollDataById(int empID);
	
	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);
	
	EmployeePayrollData updateEmployeePayrollData(int empID,EmployeePayrollDTO empPayrollDTO);
	
	
	void deleteEmployeePayrollData(int empID);

	List<EmployeePayrollData> getEmployeesByDepartment(String department);
}
