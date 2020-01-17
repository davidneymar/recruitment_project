package com.mindgate.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.daoImpl.ProjectDAOImpl;
import com.mindgate.dto.ProjectDto;
import com.mindgate.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAOImpl projectDao; 
	
	@Override
	public List<ProjectDto> getAllProject() {
		return projectDao.getAllProject();
	}

	@Override
	public ProjectDto getProject(int projectId) {
		return projectDao.getProject(projectId);
	}

	@Override
	public boolean deleteProject(int projectId) {
		return projectDao.deleteProject(projectId);
	}

	@Override
	public boolean updateProject(ProjectDto project) {
		return projectDao.updateProject(project);
	}

	@Override
	public boolean postProject(ProjectDto project) {
		return projectDao.postJobProject(project);
	}

}
