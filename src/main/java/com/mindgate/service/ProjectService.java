package com.mindgate.service;

import java.util.List;

import com.mindgate.dto.ProjectDto;

public interface ProjectService {

	public List<ProjectDto> getAllProject();
	
	public ProjectDto getProject(int ProjectId);
	
	public boolean deleteProject(int ProjectId);
	
	public boolean updateProject(ProjectDto Project);
	
	public boolean postProject(ProjectDto Project);
	

}
