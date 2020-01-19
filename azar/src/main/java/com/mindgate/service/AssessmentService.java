package com.mindgate.service;

import java.util.List;

import com.mindgate.dto.AssessmentDto;

public interface AssessmentService {

	public List<AssessmentDto> getAllAssessment();
	
	public AssessmentDto getAssessment(int assessmentId);
	
	public boolean deleteAssessment(int assessmentId);
	
	public boolean updateAssessment(int id,AssessmentDto assessment);
	
	public boolean addAssessment(AssessmentDto assessment);

}
