package com.mindgate.service;

import java.util.List;

import com.mindgate.dto.EmployeeDto;

public interface EmployeeService {

    public boolean addEmployee(EmployeeDto employee);
	
	public boolean updateEmployee(int id,EmployeeDto employee);
	
	public boolean deleteEmployee(int employeeId);
	
	public EmployeeDto getEmployee(int employeeId);
	
	public List<EmployeeDto> getAllEmployees();
}
