package com.bridgelabz.employee.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.employee.model.EmployeePayrollData;

public interface EmployeePayrollRepository  extends JpaRepository<EmployeePayrollData,Integer>{

}
