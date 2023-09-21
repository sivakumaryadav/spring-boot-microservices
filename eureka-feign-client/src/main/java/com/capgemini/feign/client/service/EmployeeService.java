package com.capgemini.feign.client.service;

import com.capgemini.feign.client.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@FeignClient(name = "Eureka-Discovery-Client", url = "http://localhost:8011/employee")
public interface EmployeeService {

    @GetMapping("/findAllEmployees")
    public List<Employee> findAllEmployees();
}
