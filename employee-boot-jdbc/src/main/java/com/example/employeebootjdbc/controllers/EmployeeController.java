package com.example.employeebootjdbc.controllers;

import com.example.employeebootjdbc.model.Employee;
import com.example.employeebootjdbc.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/save")
    public ResponseEntity<Object> insertEmployee(@RequestBody Employee employee) {
        employeeService.insertEmployee(employee);
        return new ResponseEntity<>(new EmployeeResponse("Record Inserted Successfully", "DATA_SAVED"), HttpStatus.OK);
    }
}
