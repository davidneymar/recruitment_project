package com.mindgate.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mindgate.dao.JobDescriptionDAO;
import com.mindgate.dto.JobDescriptionDto;

@Repository
public class JobDescriptionDAOImpl implements JobDescriptionDAO{

	@Override
	public List<JobDescriptionDto> getAllJobDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobDescriptionDto getJobDescription(int assessmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteJobDescription(int assessmentId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateJobDescription(JobDescriptionDto assessment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean postJobDescription(JobDescriptionDto assessment) {
		// TODO Auto-generated method stub
		return false;
	}

}
