package com.mindgate.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.daoImpl.AssessmentDaoImpl;
import com.mindgate.dto.AssessmentDto;
import com.mindgate.service.AssessmentService;

@Service
public class AssessmentServiceImpl implements AssessmentService {

	@Autowired
	private AssessmentDaoImpl assessmentDao;
	
	@Override
	public List<AssessmentDto> getAllAssessment() {
		return assessmentDao.getAllAssessment();
	}

	@Override
	public AssessmentDto getAssessment(int assessmentId) {
		return assessmentDao.getAssessment(assessmentId);
	}

	@Override
	public boolean deleteAssessment(int assessmentId) {
		return assessmentDao.deleteAssessment(assessmentId);
	}

	@Override
	public boolean updateAssessment(int id, AssessmentDto assessment) {
		return assessmentDao.updateAssessment(id,assessment);
	}

	@Override
	public boolean addAssessment(AssessmentDto assessment) {
		return assessmentDao.addAssessment(assessment);
	}

}
