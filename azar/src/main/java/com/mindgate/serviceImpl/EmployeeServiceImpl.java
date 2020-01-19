package com.mindgate.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.daoImpl.EmployeeDAOImpl;
import com.mindgate.dto.EmployeeDto;
import com.mindgate.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAOImpl employeeDao;
	
	@Override
	public boolean addEmployee(EmployeeDto employee) {
		return employeeDao.addEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		return employeeDao.deleteEmployee(employeeId);
	}

	@Override
	public EmployeeDto getEmployee(int employeeId) {
		return employeeDao.getEmployee(employeeId);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public boolean updateEmployee(int id,EmployeeDto employee) {
		return employeeDao.updateEmployee(id,employee);
	}

	
}
