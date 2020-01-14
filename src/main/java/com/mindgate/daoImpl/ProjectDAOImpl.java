package com.mindgate.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mindgate.dao.ProjectDAO;
import com.mindgate.dto.ProjectDto;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

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
	public boolean postJobProject(ProjectDto Project) {
		// TODO Auto-generated method stub
		return false;
	}

}
