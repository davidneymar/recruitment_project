package com.mindgate.dto;

public class JobDescriptionDto {
	
	private int jobDescId;
	private String experience;
	private String qualification;
	private String primarySkills;
	private String secondarySkills;
	private String designation;
	private int noOfVacancies;
	private ProjectDetailsDto projectDetails;	//forign key
	
	public JobDescriptionDto() {
		// TODO Auto-generated constructor stub
	}

	public JobDescriptionDto(int jobDescId, String experience, String qualification, String primarySkills,
			String secondarySkills, String designation, int noOfVacancies, ProjectDetailsDto projectDetails) {
		super();
		this.jobDescId = jobDescId;
		this.experience = experience;
		this.qualification = qualification;
		this.primarySkills = primarySkills;
		this.secondarySkills = secondarySkills;
		this.designation = designation;
		this.noOfVacancies = noOfVacancies;
		this.projectDetails = projectDetails;
	}

	public int getJobDescId() {
		return jobDescId;
	}

	public void setJobDescId(int jobDescId) {
		this.jobDescId = jobDescId;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getPrimarySkills() {
		return primarySkills;
	}

	public void setPrimarySkills(String primarySkills) {
		this.primarySkills = primarySkills;
	}

	public String getSecondarySkills() {
		return secondarySkills;
	}

	public void setSecondarySkills(String secondarySkills) {
		this.secondarySkills = secondarySkills;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getNoOfVacancies() {
		return noOfVacancies;
	}

	public void setNoOfVacancies(int noOfVacancies) {
		this.noOfVacancies = noOfVacancies;
	}

	public ProjectDetailsDto getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(ProjectDetailsDto projectDetails) {
		this.projectDetails = projectDetails;
	}

	@Override
	public String toString() {
		return "JobDescriptionDto [jobDescId=" + jobDescId + ", experience=" + experience + ", qualification="
				+ qualification + ", primarySkills=" + primarySkills + ", secondarySkills=" + secondarySkills
				+ ", designation=" + designation + ", noOfVacancies=" + noOfVacancies + ", projectDetails="
				+ projectDetails + "]";
	}
	
	

}
