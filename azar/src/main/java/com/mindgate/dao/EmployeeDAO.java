package com.mindgate.dao;

import java.util.List;

import com.mindgate.dto.EmployeeDto;

public interface EmployeeDAO {

public boolean addEmployee(EmployeeDto employee);
	
	public boolean updateEmployee(int id,EmployeeDto employee);
	
	public boolean deleteEmployee(int employeeID);
	
	public EmployeeDto getEmployee(int employeeID);
	
	public List<EmployeeDto> getAllEmployees();
}
