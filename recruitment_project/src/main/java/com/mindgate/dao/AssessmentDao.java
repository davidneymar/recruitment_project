package com.mindgate.dao;

import java.util.List;

import com.mindgate.dto.AssessmentDto;

public interface AssessmentDao {


	public List<AssessmentDto> getAllAssessment();
	
	public AssessmentDto getPerAssessment(int assessmentId);
	
	public boolean deletePerAssessment(int assessmentId);
	
	public boolean updateAssessment(int assessmentId,AssessmentDto assessment);
	
	public boolean putPerAssessment(AssessmentDto assessment);

}
