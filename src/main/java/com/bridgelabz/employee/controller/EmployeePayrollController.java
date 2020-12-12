package com.bridgelabz.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employee.dto.EmployeePayrollDTO;
import com.bridgelabz.employee.dto.ResponseDTO;
import com.bridgelabz.employee.model.EmployeePayrollData;
import com.bridgelabz.employee.service.IEmployeePayrollService;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
	
	@Autowired
	private IEmployeePayrollService employeePayrollService;
	
	@RequestMapping(value= {"","/","/get"})
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
		List<EmployeePayrollData> empDataList=null;
		empDataList = employeePayrollService.getEmployeePayrollData();
		ResponseDTO respDTO = new ResponseDTO("GET call for Id succesful",empDataList);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empID){
		EmployeePayrollData empData=null;
		empData = employeePayrollService.getEmployeePayrollDataById(empID);
		ResponseDTO respDTO = new ResponseDTO("GET call for Id succesful",empData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
		EmployeePayrollData empData=null;
		empData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Created EmployeePayrollData Succesfully",empData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
		EmployeePayrollData empData=null;
		empData = employeePayrollService.updateEmployeePayrollData(1, empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated EmployeePayrollData Succesfully",empData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empID}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empID){
		employeePayrollService.deleteEmployeePayrollData(empID);
		ResponseDTO respDTO = new ResponseDTO("Deleted Successfully","Deleted Id:"+empID);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
}
