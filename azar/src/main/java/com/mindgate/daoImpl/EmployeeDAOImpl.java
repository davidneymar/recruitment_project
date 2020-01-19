package com.mindgate.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mindgate.dao.EmployeeDAO;
import com.mindgate.dto.EmployeeDto;
import com.mindgate.dto.ProjectDto;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private ProjectDAOImpl projectdao;
	
	private String sql;
	private int count;
	
	@Override
	public boolean addEmployee(EmployeeDto employee) {
		sql = "insert into employee_master values(employee_id.nextVal,?,?,?,?,?,?,?)";
		Integer fk= null;
		if(employee.getProject().getProjecId() != 0){
			fk = employee.getProject().getProjecId();
		}
		Object[] args = new Object[] { 
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
	public boolean updateEmployee(int id,EmployeeDto employee) {
		sql = "update employee_master set DESIGNATION=?,"
				+ "EXPERIENCE=?,"
				+ "PRIMARY_SKILL=?,"
				+ "SECONDARY_SKILLS=?,"
				+ "STATUS=?,"
				+ "EMPLOYEE_PASSWORD=?"
				+ "where EMPLOYEE_ID=?";
		Object[] obj = new Object[]{
				employee.getDesignation(),
				employee.getExperience(),
				employee.getPrimarySkill(),
				employee.getSecondarySkill(),
				employee.getStatus(),
				employee.getPassword(),
				id
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
			employee.setEmployeeId(Integer.valueOf(map.get("employee_Id").toString()));
			employee.setDesignation(map.get("designation").toString());
			employee.setExperience(Float.valueOf(map.get("experience").toString()));
			employee.setPrimarySkill(map.get("primary_Skill").toString());
			employee.setSecondarySkill(map.get("secondary_Skills").toString());
			employee.setPassword(map.get("employee_password").toString());
			employee.setStatus(map.get("status").toString());
			
			if(Integer.valueOf(map.get("project_Id").toString()) != null){
				int projectId = Integer.valueOf(map.get("project_Id").toString());
				employee.setProject(projectdao.getProject(projectId));
			}else
				employee.setProject(null);
			employeeList.add(employee);
		}
		return employeeList;		
	}

	public class EmployeeRowMapper implements RowMapper<EmployeeDto>{
		@Override
		public EmployeeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProjectDto project = null;
			if(rs.getInt("project_id") != 0)
				project = projectdao.getProject(rs.getInt("project_id"));
			
			EmployeeDto employee = new EmployeeDto(
					rs.getInt("employee_id"),
					rs.getString("designation"),
					rs.getFloat("experience"),
					rs.getString("primary_skill"),
					rs.getString("secondary_skills"),
					rs.getString("status"),
					rs.getString("EMPLOYEE_PASSWORD"),
					project
					);
			return employee;
		}
	}
}
