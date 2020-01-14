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
	AssessmentDaoImpl assessmentDao;
	
	@Override
	public List<AssessmentDto> getAllAssessment() {
		return assessmentDao.getAllAssessment();
	}

	@Override
	public AssessmentDto getPerAssessment(int assessmentId) {
		return assessmentDao.getAssessment(assessmentId);
	}

	@Override
	public boolean deletePerAssessment(int assessmentId) {
		return assessmentDao.deletePerAssessment(assessmentId);
	}

	@Override
	public boolean updateAssessment( AssessmentDto assessment) {
		return assessmentDao.updateAssessment(assessment);
	}

	@Override
	public boolean putPerAssessment(AssessmentDto assessment) {
		return assessmentDao.postAssessment(assessment);
	}

}