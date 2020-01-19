package com.mindgate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.dto.AssessmentDto;
import com.mindgate.serviceImpl.AssessmentServiceImpl;

@RestController
@RequestMapping("/assessment")
public class AssessmentController {

	@Autowired
	AssessmentServiceImpl assessmentService;
	
	@GetMapping("/getAll")
	public List<AssessmentDto> getAllAssessment() {
		return assessmentService.getAllAssessment();
	}
	
	@GetMapping("/{id}")
	public AssessmentDto getAssessment(@PathVariable("id") int assessmentId) {
		return assessmentService.getAssessment(assessmentId);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteAssessment(@PathVariable("id") int assessmentId) {
		return assessmentService.deleteAssessment(assessmentId);
	}
	
	@PutMapping("/{id}")
	public boolean updateAssessment(@PathVariable("id") int id,@RequestBody AssessmentDto assessment) {
		return assessmentService.updateAssessment(id,assessment);
	}
	
	@PostMapping("/")
	public boolean addAssessment(@RequestBody AssessmentDto assessment) {
		return assessmentService.addAssessment(assessment);
	}
}
