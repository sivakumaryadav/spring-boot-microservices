package com.capgemini.feign.client.controller;

import com.capgemini.feign.client.model.Employee;
import com.capgemini.feign.client.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/feign-client/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/findAllEmployees")
    public List<Employee> findAllEmployees() {
        log.info("feign-client findAll Employee Service invoked.");
        return employeeService.findAllEmployees().stream().filter(e -> e.getSalary() > 10000).collect(Collectors.toList());
    }
}
