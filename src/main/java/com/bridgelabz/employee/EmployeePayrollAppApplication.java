package com.bridgelabz.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmployeePayrollAppApplication {

	public static void main(String[] args) {
				SpringApplication.run(EmployeePayrollAppApplication.class, args);
		
		log.info("Employee Payroll App Started");
	}

}
