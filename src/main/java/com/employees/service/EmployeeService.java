package com.employees.service;

import com.employees.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployeeById(Long id);
}
