package com.mindgate.dao;

import java.util.List;

import com.mindgate.dto.JobDescriptionDto;
import com.mindgate.dto.ProjectDto;

public interface ProjectDAO {

    public List<ProjectDto> getAllProject();
	
	public ProjectDto getProject(int ProjectId);
	
	public boolean deleteProject(int ProjectId);
	
	public boolean updateProject(int id,ProjectDto Project);
	
	public boolean addJobProject(ProjectDto Project);
}
