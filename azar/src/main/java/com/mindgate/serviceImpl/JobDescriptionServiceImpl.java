package com.mindgate.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.daoImpl.JobDescriptionDAOImpl;
import com.mindgate.dto.JobDescriptionDto;
import com.mindgate.service.JobDescriptionService;

@Service
public class JobDescriptionServiceImpl implements JobDescriptionService {

	@Autowired
	private JobDescriptionDAOImpl jobDescDao;
	
	@Override
	public List<JobDescriptionDto> getAllJobDescription() {
		return jobDescDao.getAllJobDescription();
	}

	@Override
	public JobDescriptionDto getJobDescription(int jobDescId) {
		return jobDescDao.getJobDescription(jobDescId);
	}

	@Override
	public boolean deleteJobDescription(int jobDescId) {
		return jobDescDao.deleteJobDescription(jobDescId);
	}

	@Override
	public boolean updateJobDescription(int id,JobDescriptionDto jobDesc) {
		return jobDescDao.updateJobDescription(id,jobDesc);
	}

	@Override
	public boolean postJobDescription(JobDescriptionDto jobDesc) {
		return jobDescDao.postJobDescription(jobDesc);
	}

}
