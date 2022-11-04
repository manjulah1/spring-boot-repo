package com.example.employeebootjdbc.services.impl;

import com.example.employeebootjdbc.dao.EmployeeDao;
import com.example.employeebootjdbc.model.Employee;
import com.example.employeebootjdbc.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    @Override
    public void insertEmployee(Employee employee) {
        employeeDao.insertEmployee(employee);
    }

    @Override
    public void insertEmployees(List<Employee> employees) {
        employeeDao.insertEmployees(employees);
    }

    @Override
    public void getAllEmployees() {
        List<Employee> employees = employeeDao.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    @Override
    public void getEmployeeById(String employeeId) {
        Employee employee = employeeDao.getEmployeeById(employeeId);
        System.out.println(employee);
    }
}
