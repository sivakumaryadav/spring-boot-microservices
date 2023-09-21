package com.capgemini.feign.client.controller;

import com.capgemini.feign.client.model.Employee;
import com.capgemini.feign.client.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feign-client/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/findAllEmployees")
    public List<Employee> findAllEmployees() {
        return employeeService.findAllEmployees();
    }
}
