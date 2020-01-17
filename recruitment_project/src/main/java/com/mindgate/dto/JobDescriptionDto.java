package com.mindgate.dto;

public class JobDescriptionDto {
	
	private int jobDescId;
	private float experience;
	private String qualification;
	private String primarySkill;
	private String secondarySkills;
	private String designation;
	private int noOfVacancies;
	private ProjectDto projectDetails;	//forign key
	
	public JobDescriptionDto() {
		// TODO Auto-generated constructor stub
	}

	public JobDescriptionDto(int jobDescId, float experience, String qualification, String primarySkill,
			String secondarySkills, String designation, int noOfVacancies, ProjectDto projectDetails) {
		super();
		this.jobDescId = jobDescId;
		this.experience = experience;
		this.qualification = qualification;
		this.primarySkill = primarySkill;
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

	public float getExperience() {
		return experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getPrimarySkill() {
		return primarySkill;
	}

	public void setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
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

	public ProjectDto getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(ProjectDto projectDetails) {
		this.projectDetails = projectDetails;
	}

	@Override
	public String toString() {
		return "JobDescriptionDto [jobDescId=" + jobDescId + ", experience=" + experience + ", qualification="
				+ qualification + ", primarySkills=" + primarySkill + ", secondarySkills=" + secondarySkills
				+ ", designation=" + designation + ", noOfVacancies=" + noOfVacancies + ", projectDetails="
				+ projectDetails + "]";
	}
	
}
