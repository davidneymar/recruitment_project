package com.mindgate.service;

import java.util.List;

import com.mindgate.dto.JobDescriptionDto;

public interface JobDescriptionService {

  public List<JobDescriptionDto> getAllJobDescription();
	
	public JobDescriptionDto getJobDescription(int JobDescriptionId);
	
	public boolean deleteJobDescription(int JobDescriptionId);
	
	public boolean updateJobDescription(int id,JobDescriptionDto JobDescription);
	
	public boolean postJobDescription(JobDescriptionDto JobDescription);
}
