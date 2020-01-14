package com.mindgate.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindgate.dto.JobDescriptionDto;
import com.mindgate.service.JobDescriptionService;

@Service
public class JobDescriptionServiceImpl implements JobDescriptionService {

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
