package com.mindgate.dto;

import java.sql.Timestamp;
import java.util.Arrays;


public class CandidateListDto {
	
	private int candidateId;
	private String name;
	private String qualification;
	private float experience;
	private String email;
	private String phoneNo;
	private String primarySkill;
	private String secondarySkills;
	private byte[] resume;   //  instead of Clob 
	private byte[] photograph;// instead of Blob
	private Timestamp date;
	private String status;
	private JobDescriptionDto jobDesc; // forign key
	
	public CandidateListDto() {
		// TODO Auto-generated constructor stub
	}

	public CandidateListDto(int candidateId, String name, String qualification, float experience, String email,
			String phoneNo, String primarySkill, String secondarySkills, byte[] resume, byte[] photograph,
			Timestamp date, String status, JobDescriptionDto jobDesc) {
		super();
		this.candidateId = candidateId;
		this.name = name;
		this.qualification = qualification;
		this.experience = experience;
		this.email = email;
		this.phoneNo = phoneNo;
		this.primarySkill = primarySkill;
		this.secondarySkills = secondarySkills;
		this.resume = resume;
		this.photograph = photograph;
		this.date = date;
		this.status = status;
		this.jobDesc = jobDesc;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public float getExperience() {
		return experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	public byte[] getPhotograph() {
		return photograph;
	}

	public void setPhotograph(byte[] photograph) {
		this.photograph = photograph;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public JobDescriptionDto getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(JobDescriptionDto jobDesc) {
		this.jobDesc = jobDesc;
	}

	@Override
	public String toString() {
		return "CandidateListDto [candidateId=" + candidateId + ", name=" + name + ", qualification=" + qualification
				+ ", experience=" + experience + ", email=" + email + ", phoneNo=" + phoneNo + ", primarySkills="
				+ primarySkill + ", secondarySkills=" + secondarySkills + ", resume=" + Arrays.toString(resume)
				+ ", photograph=" + Arrays.toString(photograph) + ", date=" + date + ", status=" + status + ", jobDesc="
				+ jobDesc + "]";
	}

	
}
