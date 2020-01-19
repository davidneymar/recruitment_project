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

import com.mindgate.dao.JobDescriptionDAO;
import com.mindgate.dto.JobDescriptionDto;
import com.mindgate.dto.ProjectDto;

@Repository
public class JobDescriptionDAOImpl implements JobDescriptionDAO{

      @Autowired
      private JdbcTemplate jdbcTemplate;
      @Autowired
      private ProjectDAOImpl projectDao;
      
      private String sql;
      private int count=0;
      
	@Override
	public List<JobDescriptionDto> getAllJobDescription() {
		sql = "select * from job_description"; // please check table name
		
		List<Map<String, Object>> listMapJobDesc = jdbcTemplate.queryForList(sql);
		List<JobDescriptionDto> listJobDesc = new ArrayList<JobDescriptionDto>();
		for(Map<String,Object> data : listMapJobDesc) {
			JobDescriptionDto jobDesc = new JobDescriptionDto();
					jobDesc.setJobDescId(Integer.valueOf(data.get("job_Description_id").toString()));
					jobDesc.setExperience(Float.valueOf(data.get("experience").toString()));
					jobDesc.setQualification(data.get("qualification").toString());
					jobDesc.setPrimarySkill(data.get("primary_Skill").toString());
					jobDesc.setSecondarySkills(data.get("secondary_Skills").toString());
					jobDesc.setDesignation(data.get("designation").toString());
					jobDesc.setNoOfVacancies(Integer.valueOf(data.get("NO_OF_RESORCES_REQUIRED").toString()));
					jobDesc.setStatus(data.get("status").toString());
					
					if(Integer.valueOf(data.get("project_id").toString()) != null) {
						jobDesc.setProjectDetails(projectDao.getProject(Integer.valueOf(data.get("project_id").toString())));
					}else
						jobDesc.setProjectDetails(new ProjectDto());
					listJobDesc.add(jobDesc);	                          
		}
		return listJobDesc;
	}

	@Override
	public JobDescriptionDto getJobDescription(int jobDescId) {
		System.out.println("JOB DESCRIPTION");
		sql="select * from job_description where JOB_DESCRIPTION_ID="+jobDescId;
		return jdbcTemplate.queryForObject(sql, new JobDescriptionRowMapper());
	}

	@Override
	public boolean deleteJobDescription(int jobDescId) {
		sql = "delete from job_description where JOB_DESCRIPTION_ID="+jobDescId;
		count = jdbcTemplate.update(sql);
		if(count > 0)
			return true;
		return false;
	}

	@Override
	public boolean updateJobDescription(int id,JobDescriptionDto jobDesc) {
		sql = "update job_description set "
				+ "JOB_DESCRIPTION_ID=?,"
				+ "experience=?,"
				+ "qualification=?,"
				+ "primary_Skill=?,"
				+ "secondary_Skills=?,"
				+ "designation=?,"
				+ "NO_OF_RESORCES_REQUIRED=?,"   
				+ "status=?"
				+ "where JOB_DESCRIPTION_ID=?";
		Object[] obj = new Object[] {
				jobDesc.getJobDescId(),
				jobDesc.getExperience(),
				jobDesc.getQualification(),
				jobDesc.getPrimarySkill(),
				jobDesc.getSecondarySkills(),
				jobDesc.getDesignation(),
				jobDesc.getNoOfVacancies(),
				jobDesc.getStatus(),
				id
		};
		count = jdbcTemplate.update(sql,obj);
		if(count > 0)
			return true;
		return false;
	}
	
	@Override
	public boolean postJobDescription(JobDescriptionDto jobDesc) {
		sql = "insert into job_description values(employee_id.nextVal,?,?,?,?,?,?,?,?,?)";
		Integer fk = null;
		if(jobDesc.getProjectDetails().getProjecId() != 0)
			fk = jobDesc.getProjectDetails().getProjecId();
		Object[] obj = new Object[] {
				jobDesc.getJobDescId(),
				jobDesc.getExperience(),
				jobDesc.getQualification(),
				jobDesc.getPrimarySkill(),
				jobDesc.getSecondarySkills(),
				jobDesc.getDesignation(),
				jobDesc.getNoOfVacancies(),
				jobDesc.getStatus(),
                fk
		};
		count = jdbcTemplate.update(sql,obj);
		if(count > 0)
			return true;
 		return false;
	}

	private class JobDescriptionRowMapper implements RowMapper<JobDescriptionDto>{
		
		@Override
		public JobDescriptionDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProjectDto project = null;
			if(rs.getInt("project_id") != 0){
				project = projectDao.getProject(rs.getInt("project_id"));
			}
			
			JobDescriptionDto job = new JobDescriptionDto();
			job.setJobDescId(rs.getInt("JOB_DESCRIPTION_ID"));
			System.out.println("ROWMAPPER = "+job.getJobDescId());
			job.setExperience(rs.getFloat("EXPERIENCE"));
			job.setQualification(rs.getString("QUALIFICATION"));
			job.setPrimarySkill(rs.getString("PRIMARY_SKILL"));
			job.setSecondarySkills(rs.getString("SECONDARY_SKILLS"));
			job.setDesignation(rs.getString("DESIGNATION"));
			job.setNoOfVacancies(rs.getInt("NO_OF_RESORCES_REQUIRED"));
			job.setStatus(rs.getString("status"));
			job.setProjectDetails(project);
			return job;
		}
	}
}
