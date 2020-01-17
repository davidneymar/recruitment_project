package com.mindgate.dto;

public class ProjectDto {

	private int projectId;
	private String name;
	private double budget;
	private  int noOfResourceDeployed;
	
	public ProjectDto() {
		// TODO Auto-generated constructor stub
	}

	public ProjectDto(int projecId, String name, double budget, int noOfResourceDeployed) {
		super();
		this.projectId = projecId;
		this.name = name;
		this.budget = budget;
		this.noOfResourceDeployed = noOfResourceDeployed;
	}

	public int getProjecId() {
		return projectId;
	}

	public void setProjecId(int projecId) {
		this.projectId = projecId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public int getNoOfResourceDeployed() {
		return noOfResourceDeployed;
	}

	public void setNoOfResourceDeployed(int noOfResourceDeployed) {
		this.noOfResourceDeployed = noOfResourceDeployed;
	}

	@Override
	public String toString() {
		return "ProjectDetailsDto [projecId=" + projectId + ", name=" + name + ", budget=" + budget
				+ ", noOfResourceDeployed=" + noOfResourceDeployed + "]";
	}
	
	
}
