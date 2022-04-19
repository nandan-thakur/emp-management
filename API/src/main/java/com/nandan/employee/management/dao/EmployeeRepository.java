package com.nandan.employee.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nandan.employee.management.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
