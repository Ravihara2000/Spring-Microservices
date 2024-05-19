package com.SpringbootLearning.employeeservice.service;

import com.SpringbootLearning.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);
}
