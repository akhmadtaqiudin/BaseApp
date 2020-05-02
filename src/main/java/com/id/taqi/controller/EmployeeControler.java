package com.id.taqi.controller;

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

import com.id.taqi.entity.Employee;
import com.id.taqi.services.EmployeeService;

@RestController
@CrossOrigin("*")
public class EmployeeControler {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		try {
			return employeeService.getAll();
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@GetMapping("/employees/{id}")
	public Employee getById(@PathVariable("id") Long id){
		try {
			return employeeService.getById(id);
		} catch (Exception e) {
			return null;
		}
	}
	
	@PostMapping("/employees")
	public Boolean createEmployee(@RequestBody Employee employee) {
		try {
			employeeService.save(employee);
			return true;
		} catch (Exception e) {
			return false;
		}		
	}

	@PutMapping("/employees/{id}")
	public Boolean updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id) {
		try {
			employee.setId(id);	
			employeeService.update(employee);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@DeleteMapping("/employees/{id}")
	public Boolean deleteEmployee(@PathVariable("id") Long id, Employee employee) {
		try {
			employeeService.delete(employee);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
