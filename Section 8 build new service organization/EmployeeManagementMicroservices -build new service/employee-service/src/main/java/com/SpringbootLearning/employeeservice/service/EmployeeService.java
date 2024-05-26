package com.SpringbootLearning.employeeservice.service;

import com.SpringbootLearning.employeeservice.dto.ApiResponseDto;
import com.SpringbootLearning.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponseDto getEmployeeById(Long id);
}
