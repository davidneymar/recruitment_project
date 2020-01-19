package com.mindgate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.dto.JobDescriptionDto;
import com.mindgate.serviceImpl.JobDescriptionServiceImpl;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/jobDesc")
public class JobDescriptionController {

	@Autowired
	private JobDescriptionServiceImpl jobDescService;
	
	@GetMapping("/getAll")
	public List<JobDescriptionDto> getAllJobDesc() {
		return jobDescService.getAllJobDescription();
	}
	
	@GetMapping("/{id}")
	public JobDescriptionDto getJobDesc(@PathVariable("id") int jobDescId) {
		return jobDescService.getJobDescription(jobDescId);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteJobDesc(@PathVariable("id") int jobDescId) {
		return jobDescService.deleteJobDescription(jobDescId);
	}
	
	@PutMapping("/{id}")
	public boolean updateJobDesc(@PathVariable("id") int id,@RequestBody JobDescriptionDto jobDesc) {
		return jobDescService.updateJobDescription(id,jobDesc);
	}
	
	@PostMapping("/")
	public boolean addJobDesc(@RequestBody JobDescriptionDto jobDesc) {
		return jobDescService.postJobDescription(jobDesc);
	}
}
