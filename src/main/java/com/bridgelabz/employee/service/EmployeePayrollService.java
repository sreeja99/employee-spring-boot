package com.bridgelabz.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.employee.dto.EmployeePayrollDTO;
import com.bridgelabz.employee.exception.EmployeePayrollException;
import com.bridgelabz.employee.model.EmployeePayrollData;
@Service("employeePayrollService")
public class EmployeePayrollService implements IEmployeePayrollService{
	
	public List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
	
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		 return employeePayrollList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empID) {
		return employeePayrollList.stream().filter(empData -> empData.getEmployeeId() == empID)
				                   .findFirst()
				                   .orElseThrow(()->new EmployeePayrollException("Employee not found"));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
	 EmployeePayrollData empData =null;
	 empData = new EmployeePayrollData(employeePayrollList.size()+1,empPayrollDTO);
	 employeePayrollList.add(empData);
	 return empData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empID,EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empID);
		empData.setName(empPayrollDTO.name);
		empData.setSalary(empPayrollDTO.salary);
		employeePayrollList.set(empID-1, empData);
		return empData;
	}

	@Override
	public void deleteEmployeePayrollData(int empID) {
		employeePayrollList.remove(empID-1);
		
	}
	

}
