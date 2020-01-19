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

import com.mindgate.dao.ProjectDAO;
import com.mindgate.dto.ProjectDto;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String sql;
	private int count=0;
	
	@Override
	public List<ProjectDto> getAllProject() {
	    sql = "select * from project_master"; // project_details or project_master
	    List<Map<String,Object>> data = jdbcTemplate.queryForList(sql);
	    List<ProjectDto> projectList = new ArrayList<ProjectDto>();
	    for(Map<String,Object> map : data) {
	    	ProjectDto project = new ProjectDto();
	    	project.setProjecId(Integer.valueOf(map.get("project_id").toString()));
	    	project.setName(map.get("name").toString());
	    	project.setBudget(Double.valueOf(map.get("budget").toString()));
	    	project.setNoOfResourceDeployed(Integer.valueOf(map.get("no_of_resources_deployed").toString()));
	    	projectList.add(project);
	    }
		return projectList;
	}

	@Override
	public ProjectDto getProject(int projectId) {
		System.out.println("PROJECT " + projectId);
		sql = "select * from project_master where project_id="+projectId;
		return jdbcTemplate.queryForObject(sql, new ProjectRowMapper());
	}

	@Override
	public boolean deleteProject(int projectId) {
		sql = "delete from project_master where project_id="+projectId;
		count = jdbcTemplate.update(sql);
		if(count > 0)
			return true;
		return false;
	}

	@Override
	public boolean updateProject(int id,ProjectDto project) {
		System.out.println("PROJECT" +project.toString() );
		sql = "update project_master set NAME=?,"
				+ "BUDGET=?,"
				+ "NO_OF_RESOURCES_DEPLOYED=?"
				+ "where PROJECT_ID=?";
		Object obj[] = new Object[] {
				project.getName(),
			    project.getBudget(),
			    project.getNoOfResourceDeployed(),
			    id
		};
		count = jdbcTemplate.update(sql,obj);
		if(count > 0)
			return true;
		return false;
	}

	@Override
	public boolean addJobProject(ProjectDto project) {
		sql = "insert into project_master values(project_id.nextVal,?,?,?)";
		Object[] obj = new Object[] {
				project.getName(),
				project.getBudget(),
				project.getNoOfResourceDeployed()
		};
		count = jdbcTemplate.update(sql, obj);
		if(count > 0)
			return true;
		return false;
	}
	
	private class ProjectRowMapper implements RowMapper<ProjectDto>{

		@Override
		public ProjectDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProjectDto project = new ProjectDto();
			project.setProjecId(rs.getInt("project_id"));
			project.setName(rs.getString("name"));
			System.out.println("projectName= "+project.getName());
			project.setBudget(rs.getDouble("budget"));
			project.setNoOfResourceDeployed(rs.getInt("no_of_resources_deployed"));
			return project;
		}
	}
}
