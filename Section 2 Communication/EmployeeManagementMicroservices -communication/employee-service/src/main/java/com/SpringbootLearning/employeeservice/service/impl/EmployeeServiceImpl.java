package com.SpringbootLearning.employeeservice.service.impl;

import com.SpringbootLearning.employeeservice.dto.ApiResponseDto;
import com.SpringbootLearning.employeeservice.dto.DepartmentDto;
import com.SpringbootLearning.employeeservice.dto.EmployeeDto;
import com.SpringbootLearning.employeeservice.entity.Employee;
import com.SpringbootLearning.employeeservice.repository.EmployeeRepository;
import com.SpringbootLearning.employeeservice.service.APIClient;
import com.SpringbootLearning.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    /*private RestTemplate restTemplate;*/
   /* private WebClient webClient;*/
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstname(),
                employeeDto.getLastname(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );

        Employee savedEmployee=employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = new EmployeeDto(
                employeeDto.getId(),
                employeeDto.getFirstname(),
                employee.getLastname(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );
        return savedEmployeeDto;
    }

    @Override
    public ApiResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();
//communication with rest template
/*        ResponseEntity<DepartmentDto> responseEntity=restTemplate.
                getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(),
                DepartmentDto.class);

        DepartmentDto departmentDto = responseEntity.getBody();*/

        //communication with web client
/*        DepartmentDto departmentDto=webClient.get()
                .uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();*/

//communication with spring cloud (FeignClient)
        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;
    }
}
