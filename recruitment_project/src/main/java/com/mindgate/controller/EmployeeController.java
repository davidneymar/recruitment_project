package com.mindgate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.dto.AssessmentDto;
import com.mindgate.dto.EmployeeDto;
import com.mindgate.service.EmployeeService;
import com.mindgate.service.ProjectService;
import com.mindgate.serviceImpl.AssessmentServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/getAll")
	public List<EmployeeDto> getAllAssessment() {
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public EmployeeDto getAssessment(@PathVariable("id") int employeeId) {
		return employeeService.getEmployee(employeeId);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteAssessment(@PathVariable("id") int employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}
	
	@PutMapping("/")
	public boolean updateAssessment(@RequestBody EmployeeDto employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@PostMapping("/")
	public boolean addAssessment(@RequestBody EmployeeDto employee) {
		return employeeService.addEmployee(employee);
	}
}
