package com.example.employeebootjdbc.services;

import com.example.employeebootjdbc.model.Employee;

import java.util.List;

public interface EmployeeService {

    void insertEmployee(Employee employee);
    void insertEmployees(List<Employee> employees);
    void getAllEmployees();
    void getEmployeeById(String employeeId);
}
