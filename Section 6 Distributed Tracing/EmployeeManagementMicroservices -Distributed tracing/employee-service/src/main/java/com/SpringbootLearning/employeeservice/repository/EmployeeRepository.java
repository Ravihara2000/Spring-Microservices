package com.SpringbootLearning.employeeservice.repository;

import com.SpringbootLearning.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
