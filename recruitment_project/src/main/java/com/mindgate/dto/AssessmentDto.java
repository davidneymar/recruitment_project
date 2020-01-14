package com.mindgate.dto;

public class AssessmentDto {

	private int assessmentId;
	private String technicalSkill;
	private float rating;
	private String status;
	private CandidateListDto candidatedto;
	
	public AssessmentDto() {
		// TODO Auto-generated constructor stub
	}

	public AssessmentDto(int assessmentId, String technicalSkill, float rating, String status,
			CandidateListDto candidatedto) {
		super();
		this.assessmentId = assessmentId;
		this.technicalSkill = technicalSkill;
		this.rating = rating;
		this.status = status;
		this.candidatedto = candidatedto;
	}

	public int getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
	}

	public String getTechnicalSkill() {
		return technicalSkill;
	}

	public void setTechnicalSkill(String technicalSkill) {
		this.technicalSkill = technicalSkill;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CandidateListDto getCandidatedto() {
		return candidatedto;
	}

	public void setCandidatedto(CandidateListDto candidatedto) {
		this.candidatedto = candidatedto;
	}

	@Override
	public String toString() {
		return "AssessmentDto [assessmentId=" + assessmentId + ", technicalSkill=" + technicalSkill + ", rating="
				+ rating + ", status=" + status + ", candidatedto=" + candidatedto + "]";
	}
	
	 
}
