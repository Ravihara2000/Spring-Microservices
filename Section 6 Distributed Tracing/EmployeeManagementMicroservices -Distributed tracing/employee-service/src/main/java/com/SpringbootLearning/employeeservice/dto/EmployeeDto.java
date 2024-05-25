package com.SpringbootLearning.employeeservice.dto;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String departmentCode;
}
