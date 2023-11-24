package com.capgemini.eureka.client.controller;

import com.capgemini.eureka.client.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private List<Employee> getEmployees() {
        List<Employee> employees = Arrays.asList(Employee.builder()
                .id(8001).name("akash").salary(12000).location("chennai").build(),
                Employee.builder().id(8002).name("sri").salary(6000).location("kolkata").build(),
                Employee.builder().id(8003).name("leo").salary(8500).location("pune").build(),
                Employee.builder().id(8004).name("kathir").salary(25000).location("chennai").build(),
                Employee.builder().id(8005).name("vipin").salary(50000).location("banglore").build(),
                Employee.builder().id(8006).name("rakesh").salary(3000).location("delhi").build(),
                Employee.builder().id(8007).name("dinesh").salary(7000).location("kochi").build(),
                Employee.builder().id(8008).name("khan").salary(80000).location("chennai").build());
        return employees;
    }

    @GetMapping("/getEmployee/{id}")
    public Employee getEmployee(@PathVariable long id) {
        List<Employee> employees = getEmployees();
        Optional<Employee> employee = employees.stream().filter(e -> e.getId() == id).findAny();
        if(employee.isPresent()) {
            return employee.get();
        }
        return null;
    }

    @GetMapping("/findAllEmployees")
    public List<Employee> findAllEmployees() {
        log.info("employee findAll Employee Service invoked.");
        return getEmployees();
    }
}
