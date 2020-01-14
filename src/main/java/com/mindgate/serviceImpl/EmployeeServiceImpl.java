package com.mindgate.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindgate.dto.EmployeeDto;
import com.mindgate.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public boolean addEmployee(EmployeeDto employee) {
		return false;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		return false;
	}

	@Override
	public boolean getEmployee(int employeeId) {
		return false;
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		return null;
	}

	@Override
	public boolean updateEmployee(EmployeeDto employee) {
		return false;
	}

	
}
