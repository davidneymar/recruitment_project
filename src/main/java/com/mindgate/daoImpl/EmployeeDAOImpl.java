package com.mindgate.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.mindgate.dao.EmployeeDAO;
import com.mindgate.dto.EmployeeDto;

@Service
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private ProjectDAOImpl projectdao;
	private String sql;
	private int count;
	
	@Override
	public boolean addEmployee(EmployeeDto employee) {
		sql = "insert into employee_master values(?,?,?,?,?,?,?)";
		int fk=0;
		if(employee.getProject().getProjecId() != 0){
			fk = employee.getProject().getProjecId();
		}
		Object[] args = new Object[] { 
				employee.getEmployeeId(), 
				employee.getDesignation(), 
				employee.getExperience(),
				employee.getPrimarySkill(),
				employee.getSecondarySkill(),
				employee.getPassword(),
				employee.getStatus(),
				fk
				};
		count = jdbcTemplate.update(sql, args);
		if (count > 0)
			return true;
		return false;
	}

	@Override
	public boolean updateEmployee(EmployeeDto employee) {
		sql = "update employee_master set DESIGNATION=?,"
				+ "EXPERIENCE=?,"
				+ "PRIMARY_SKILL=?,"
				+ "SECONDARY_SKILLS=?,"
				+ "STATUS=?,"
				+ "EMPLOYEE_PASSWORD=?";
		Object[] obj = new Object[]{
				employee.getDesignation(),
				employee.getExperience(),
				employee.getPrimarySkill(),
				employee.getSecondarySkill(),
				employee.getStatus(),
				employee.getPassword()
		};
		count = jdbcTemplate.update(sql,obj);
		if(count > 0)
			return true;
		return false;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		sql = "delete from employee_master where employee_id = "+employeeId;
		count = jdbcTemplate.update(sql);
		if(count > 0)
			return true;
		return false;
	}

	@Override
	public EmployeeDto getEmployee(int employeeId) {
		sql = "select * from employee_master where employee_id ="+employeeId;
		return jdbcTemplate.queryForObject(sql, new EmployeeRowMapper());
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		sql = "select * from employee_master"; 
		List<EmployeeDto> employeeList = new ArrayList<EmployeeDto>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> map : rows){
			EmployeeDto employee = new EmployeeDto();
			employee.setEmployeeId(Integer.parseInt(map.get("employee_Id").toString()));
			employee.setDesignation(map.get("designation").toString());
			employee.setExperience(Float.parseFloat(map.get("experience").toString()));
			employee.setPrimarySkill(map.get("primary_Skill").toString());
			employee.setSecondarySkill(map.get("secondary_Skills").toString());
			employee.setPassword(map.get("employee_password").toString());
			employee.setStatus(map.get("status").toString());
			
			if((int)map.get("project_Id") != 0){
				int projectId = (Integer)map.get("project_Id");
				employee.setProject(projectdao.getProject(projectId));
			}
			employeeList.add(employee);
		}
		return employeeList;		
	}

	public class EmployeeRowMapper implements RowMapper<EmployeeDto>{
		
		@Override
		public EmployeeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmployeeDto employee = new EmployeeDto(
					rs.getInt("employee_id"),
					rs.getString("designation"),
					rs.getFloat("experience"),
					rs.getString("primary_skill"),
					rs.getString("secondary_skills"),
					rs.getString("status"),
					rs.getString("password"),
					projectdao.getProject(rs.getInt("project_id"))
					//null
					);
			return employee;
		}
		
	}
	
}
