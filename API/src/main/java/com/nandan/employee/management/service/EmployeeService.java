package com.nandan.employee.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nandan.employee.management.dao.EmployeeRepository;
import com.nandan.employee.management.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> createEmployees(List<Employee> employee) {
		return employeeRepository.saveAll(employee);
	}

	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).orElse(null);
	}

	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}
	
	public Employee updateEmployee(Employee employee) {
		Employee oldEmployee=null;
		Optional<Employee> optionalemployee=employeeRepository.findById(employee.getId());
		if(optionalemployee.isPresent()) {
			oldEmployee=optionalemployee.get();
			oldEmployee.setName(employee.getName());
			oldEmployee.setCity(employee.getCity());
			employeeRepository.save(oldEmployee);
		}else {
			return new Employee();
		}
		return oldEmployee;
	}
	
	public String deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
		return "User got deleted";
	}

}
