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
					jobDesc.setPrimarySkill(data.get("primarySkill").toString());
					jobDesc.setSecondarySkills(data.get("secondarySkills").toString());
					jobDesc.setDesignation(data.get("designation").toString());
					jobDesc.setNoOfVacancies(Integer.valueOf(data.get("noOfVacancies").toString()));
					
					if((int) data.get("project_id") != 0) {
						jobDesc.setProjectDetails(projectDao.getProject(Integer.valueOf(data.get("project_id").toString())));
					}else
						jobDesc.setProjectDetails(null);
					listJobDesc.add(jobDesc);	                          
		}
		return listJobDesc;
	}

	@Override
	public JobDescriptionDto getJobDescription(int jobDescId) {
		sql="select * from job_description where job_desc_id="+jobDescId;
		return jdbcTemplate.queryForObject(sql, new JobDescriptionRowMapper());
	}

	@Override
	public boolean deleteJobDescription(int jobDescId) {
		sql = "delete from job_description where job_desc_id="+jobDescId;
		count = jdbcTemplate.update(sql);
		if(count > 0)
			return true;
		return false;
	}

	@Override
	public boolean updateJobDescription(JobDescriptionDto jobDesc) {
		sql = "update job_description set job_desc_id=?"
				+ "experience=?"
				+ "qualification=?"
				+ "primarySkill=?"
				+ "secondarySkills=?"
				+ "designation=?"
				+ "noOfVacancies=?";
		Object[] obj = new Object[] {
				jobDesc.getJobDescId(),
				jobDesc.getExperience(),
				jobDesc.getQualification(),
				jobDesc.getPrimarySkill(),
				jobDesc.getSecondarySkills(),
				jobDesc.getDesignation(),
				jobDesc.getNoOfVacancies()
		};
		count = jdbcTemplate.update(sql,obj);
		if(count > 0)
			return true;
		return false;
	}
	
	@Override
	public boolean postJobDescription(JobDescriptionDto jobDesc) {
		sql = "insert into job_description values(?,?,?,?,?,?,?,?)";
		int fk = 0;
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
			if(rs.getInt("project_id") != 0)
				projectDao.getProject(rs.getInt("project_id"));
			
			JobDescriptionDto job = new JobDescriptionDto();
			job.setJobDescId(rs.getInt("job_description_id"));
			job.setExperience(rs.getFloat("experience"));
			job.setQualification(rs.getString("qualification"));
			job.setPrimarySkill(rs.getString("primarySkill"));
			job.setSecondarySkills(rs.getString("secondarySkills"));
			job.setDesignation(rs.getString("designation"));
			job.setNoOfVacancies(rs.getInt("noOfVacancies"));
			job.setProjectDetails(project);
			return job;
		}
	}
}
