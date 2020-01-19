package com.mindgate.dao;

import java.util.List;

import com.mindgate.dto.JobDescriptionDto;


public interface JobDescriptionDAO {

public List<JobDescriptionDto> getAllJobDescription();
	
	public JobDescriptionDto getJobDescription(int assessmentId);
	
	public boolean deleteJobDescription(int assessmentId);
	
	public boolean updateJobDescription(int id,JobDescriptionDto assessment);
	
	public boolean postJobDescription(JobDescriptionDto assessment);
}
