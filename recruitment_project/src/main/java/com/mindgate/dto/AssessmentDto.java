package com.mindgate.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssessmentDto {

	private int assessmentId;
	private float rating;
	private float aptitudeScore;
	private String status;
	private float groupDiscussionScore;
	private float softSkillsScore;
	private float programTestScore;
	private CandidateListDto candidatedto;
	
	public AssessmentDto() {}

	public AssessmentDto(int assessmentId, float rating, float aptitudeScore, String status, float groupDiscussionScore,
			float softSkillsScore, float programTestScore, CandidateListDto candidatedto) {
		super();
		this.assessmentId = assessmentId;
		this.rating = rating;
		this.aptitudeScore = aptitudeScore;
		this.status = status;
		this.groupDiscussionScore = groupDiscussionScore;
		this.softSkillsScore = softSkillsScore;
		this.programTestScore = programTestScore;
		this.candidatedto = candidatedto;
	}

	public int getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public float getAptitudeScore() {
		return aptitudeScore;
	}

	public void setAptitudeScore(float aptitudeScore) {
		this.aptitudeScore = aptitudeScore;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getGroupDiscussionScore() {
		return groupDiscussionScore;
	}

	public void setGroupDiscussionScore(float groupDiscussionScore) {
		this.groupDiscussionScore = groupDiscussionScore;
	}

	public float getSoftSkillsScore() {
		return softSkillsScore;
	}

	public void setSoftSkillsScore(float softSkillsScore) {
		this.softSkillsScore = softSkillsScore;
	}

	public float getProgramTestScore() {
		return programTestScore;
	}

	public void setProgramTestScore(float programTestScore) {
		this.programTestScore = programTestScore;
	}

	public CandidateListDto getCandidatedto() {
		return candidatedto;
	}

	public void setCandidatedto(CandidateListDto candidatedto) {
		this.candidatedto = candidatedto;
	}

	@Override
	public String toString() {
		return "AssessmentDto [assessmentId=" + assessmentId + ", rating=" + rating + ", aptitudeScore=" + aptitudeScore
				+ ", status=" + status + ", groupDiscussionScore=" + groupDiscussionScore + ", softSkillsScore="
				+ softSkillsScore + ", programTestScore=" + programTestScore + ", candidatedto=" + candidatedto + "]";
	}

	

	 
}
