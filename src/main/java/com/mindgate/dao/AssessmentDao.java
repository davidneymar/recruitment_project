package com.mindgate.dao;

import java.util.List;

import com.mindgate.dto.AssessmentDto;

public interface AssessmentDao {


	public List<AssessmentDto> getAllAssessment();
	
	public AssessmentDto getAssessment(int assessmentId);
	
	public boolean deletePerAssessment(int assessmentId);
	
	public boolean updateAssessment(AssessmentDto assessment);
	
	public boolean postAssessment(AssessmentDto assessment);

}
