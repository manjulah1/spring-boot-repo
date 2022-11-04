package com.example.employeebootjdbc.dao;

import com.example.employeebootjdbc.model.Employee;

import java.util.List;

public interface EmployeeDao {
    void insertEmployee(Employee cus);
    void insertEmployees(List<Employee> employees);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(String employeeId);
}
