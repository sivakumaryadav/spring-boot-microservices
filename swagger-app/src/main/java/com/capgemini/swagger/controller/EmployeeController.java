package com.capgemini.swagger.controller;

import java.time.LocalDate;
import java.util.Optional;

import com.capgemini.swagger.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

	@GetMapping
	@RequestMapping("/loadEmployee")
	public Optional<Employee> loadEmployee(final String employeeId) {
		LOG.info("Input values to get the employee details : {}", employeeId);
		
		if("46111535".equalsIgnoreCase(employeeId)) {
			Employee employee = Employee.builder()
					.employeeId(employeeId)
					.department("FS")
					.grade("C1")
					.name("Siva Kumar")
					.project("ICRS Kafka Data Migration")
					.client("TransUnion")
					.doj(LocalDate.of(2021,8, 5))
					.build();
			return Optional.of(employee);
		}
		LOG.warn("Employee not found for employeeId : {}", employeeId);
		return Optional.empty();
	}
	
}