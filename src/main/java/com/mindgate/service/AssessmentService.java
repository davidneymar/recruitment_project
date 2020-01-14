package com.mindgate.service;

import java.util.List;

import com.mindgate.dto.AssessmentDto;

public interface AssessmentService {

	public List<AssessmentDto> getAllAssessment();
	
	public AssessmentDto getPerAssessment(int assessmentId);
	
	public boolean deletePerAssessment(int assessmentId);
	
	public boolean updateAssessment(AssessmentDto assessment);
	
	public boolean putPerAssessment(AssessmentDto assessment);

}
