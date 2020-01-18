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

import com.mindgate.dto.ProjectDto;
import com.mindgate.serviceImpl.ProjectServiceImpl;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectServiceImpl projectService;
	
	@GetMapping("/getAll")
	public List<ProjectDto> getAllproject() {
		return projectService.getAllProject();
	}
	
	@GetMapping("/{id}")
	public ProjectDto getproject(@PathVariable("id") int projectId) {
		return projectService.getProject(projectId);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteproject(@PathVariable("id") int projectId) {
		return projectService.deleteProject(projectId);
	}
	
	@PutMapping("/{id}")
	public boolean updateproject(@PathVariable("id") int id, @RequestBody ProjectDto project) {
		return projectService.updateProject(id,project);
	}
	
	@PostMapping("/")
	public boolean addproject(@RequestBody ProjectDto project) {
		return projectService.addProject(project);
	}
}
