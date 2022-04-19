package com.nandan.employee.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nandan.employee.management.entity.Employee;
import com.nandan.employee.management.service.EmployeeService;

@CrossOrigin
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employee/{id}")
	public Employee getUserById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}

	@GetMapping("/employees")
	public List<Employee> getAllUsers() {
		return employeeService.getEmployees();
	}
	
	@PutMapping("/employee")
	public Employee updateUser(@RequestBody Employee user) {
		return employeeService.updateEmployee(user);
	}
	
	@PostMapping("/employee")
	public Employee addUser(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}

	@DeleteMapping("/employee/{id}")
	public String deleteUser(@PathVariable int id) {
		return employeeService.deleteEmployeeById(id);
	}
}
