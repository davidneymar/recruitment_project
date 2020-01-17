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

import com.mindgate.dto.CandidateListDto;
import com.mindgate.serviceImpl.CandidateListServiceImpl;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	private CandidateListServiceImpl candidateService;
	
	@GetMapping("/getAll")
	public List<CandidateListDto> getAllcandidate() {
		return candidateService.getAllCandidate();
	}
	
	@GetMapping("/{id}")
	public CandidateListDto getcandidate(@PathVariable("id") int candidateId) {
		return candidateService.getCandidate(candidateId);
	}
	
	@DeleteMapping("/{id}")
	public boolean deletecandidate(@PathVariable("id") int candidateId) {
		return candidateService.deleteCandidate(candidateId);
	}
	
	@PutMapping("/")
	public boolean updatecandidate(@RequestBody CandidateListDto candidate) {
		return candidateService.updateCandidate(candidate);
	}
	
	@PostMapping("/")
	public boolean addcandidate(@RequestBody CandidateListDto candidate) {
		return candidateService.addCandidate(candidate);
	}
}
