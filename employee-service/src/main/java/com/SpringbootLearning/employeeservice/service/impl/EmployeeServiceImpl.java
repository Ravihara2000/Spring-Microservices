package com.SpringbootLearning.employeeservice.service.impl;

import com.SpringbootLearning.employeeservice.dto.EmployeeDto;
import com.SpringbootLearning.employeeservice.entity.Employee;
import com.SpringbootLearning.employeeservice.repository.EmployeeRepository;
import com.SpringbootLearning.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstname(),
                employeeDto.getLastname(),
                employeeDto.getEmail()
        );

        Employee savedEmployee=employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = new EmployeeDto(
                employeeDto.getId(),
                employeeDto.getFirstname(),
                employee.getLastname(),
                employee.getEmail()
        );
        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getEmail()
        );
        return employeeDto;
    }
}
