package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	public Employee registerEmployee(Employee employee) {
		Employee employee1 = employeeRepo.save(employee);
		return employee;
		
	}
	public List<Employee> getAllEmployee(){
		List<Employee> allEmployees = employeeRepo.findAll();
		return allEmployees;
		
	}
	
	public Employee getByEmployeeId(long id) {
		Employee employee = employeeRepo.getById(id);
		return employee;
	}
	public Employee updateEmployee(Employee employee)
	{
		Employee emp=employeeRepo.getById(employee.getId());
		if(emp!=null)
		{
			emp.setFirstName(employee.getFirstName());
			emp.setEmailId(employee.getEmailId());
			emp.setLastName(employee.getLastName());
			employeeRepo.save(emp);
			return emp;
		}
		return emp;
	}

}
