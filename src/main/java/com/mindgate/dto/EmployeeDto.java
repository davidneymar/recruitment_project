package com.mindgate.dto;

public class EmployeeDto {

	private int employeeId;
	//private String name;  //have to add column(name) into the database
	private String designation;
	private float experience;
	private String primarySkill;
	private String secondarySkill;
	private String status;
	private String password;
	private ProjectDto project;
	
	public EmployeeDto() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeDto(int employeeId, String designation, float experience, String primarySkill, String secondarySkill,
			String status, String password, ProjectDto project) {
		super();
		this.employeeId = employeeId;
		this.designation = designation;
		this.experience = experience;
		this.primarySkill = primarySkill;
		this.secondarySkill = secondarySkill;
		this.status = status;
		this.password = password;
		this.project = project;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public float getExperience() {
		return experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}

	public String getPrimarySkill() {
		return primarySkill;
	}

	public void setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
	}

	public String getSecondarySkill() {
		return secondarySkill;
	}

	public void setSecondarySkill(String secondarySkill) {
		this.secondarySkill = secondarySkill;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ProjectDto getProject() {
		return project;
	}

	public void setProject(ProjectDto project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "EmployeeDto [employeeId=" + employeeId + ", designation=" + designation + ", experience=" + experience
				+ ", primarySkill=" + primarySkill + ", secondarySkill=" + secondarySkill + ", status=" + status
				+ ", password=" + password + ", project=" + project + "]";
	}

	
}
