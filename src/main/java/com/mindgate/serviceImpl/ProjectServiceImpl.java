package com.mindgate.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindgate.dto.ProjectDto;
import com.mindgate.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Override
	public List<ProjectDto> getAllProject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectDto getProject(int ProjectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteProject(int ProjectId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProject(ProjectDto Project) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean putProject(ProjectDto Project) {
		// TODO Auto-generated method stub
		return false;
	}

}
