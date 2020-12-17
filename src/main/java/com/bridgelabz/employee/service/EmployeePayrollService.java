package com.bridgelabz.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employee.dto.EmployeePayrollDTO;
import com.bridgelabz.employee.exception.EmployeePayrollException;
import com.bridgelabz.employee.model.EmployeePayrollData;
import com.bridgelabz.employee.repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;
@Service("employeePayrollService")
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{
	@Autowired
	private EmployeePayrollRepository employeeRepository;
	public List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
	
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeeRepository.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empID) {
		return employeeRepository.findById(empID).
				orElseThrow(() -> new EmployeePayrollException("Employee with  EmployeeID"+empID+" Does not exists...!!"));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
	 EmployeePayrollData empData =null;
	 empData = new EmployeePayrollData(employeePayrollList.size()+1,empPayrollDTO);
	 log.debug("Employee Data: " + empData.toString());
	 employeePayrollList.add(empData);
	 return employeeRepository.save(empData);
	}
	@Override
	public List<EmployeePayrollData> getEmployeesByDepartment(String department){
		return employeeRepository.findEmployeesByDepartment(department);
	}
	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empID,EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empID);
		empData.updateEmployeePayrollData(empPayrollDTO) ;
		return employeeRepository.save(empData);
	}

	@Override
	public void deleteEmployeePayrollData(int empID) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empID);
		employeeRepository.delete(empData);
		
	}
	

}
