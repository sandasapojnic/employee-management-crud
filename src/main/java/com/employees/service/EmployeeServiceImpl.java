package com.employees.service;

import com.employees.dto.EmployeeDto;
import com.employees.entity.Employee;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import com.employees.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .map(employee -> new EmployeeDto(
                        employee.getId(),
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getDepartment()))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isEmpty())
        {
           throw new EntityNotFoundException("Employee with id " + id + "not found");
        }

        Employee employee1 = employee.get();

        return new EmployeeDto(
                employee1.getId(),
                employee1.getFirstName(),
                employee1.getLastName(),
                employee1.getDepartment());
    }
}
