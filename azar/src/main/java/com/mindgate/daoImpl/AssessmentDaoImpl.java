package com.mindgate.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mindgate.dao.AssessmentDao;
import com.mindgate.dto.AssessmentDto;
import com.mindgate.dto.CandidateListDto;
import com.mindgate.dto.ProjectDto;

@Repository
public class AssessmentDaoImpl implements AssessmentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	CandidateListDAOImpl candidateDao;
	
	private String sql;
	private int count=0;
	
	@Override
	public List<AssessmentDto> getAllAssessment() {
		sql = "select * from assessment_master";
		
		List<Map<String,Object>> listMapAssessment = jdbcTemplate.queryForList(sql);
		
		List<AssessmentDto> listAssessment = new ArrayList<AssessmentDto>();
		for(Map<String,Object> map : listMapAssessment){
			AssessmentDto assessment = new AssessmentDto();
			assessment.setAssessmentId(Integer.valueOf(map.get("ASSESSMENT_ID").toString()));
			assessment.setAptitudeScore(Float.valueOf(map.get("APTITUDE_SCORE").toString()));
			assessment.setStatus(map.get("STATUS").toString());
			assessment.setGroupDiscussionScore(Float.valueOf(map.get("GROUP_DISCUSSION_SCORE").toString()));
			assessment.setRating(Float.valueOf(map.get("rating").toString()));
			assessment.setProgramTestScore(Float.valueOf(map.get("PROGRAM_TEST_SCORE").toString()));
			assessment.setSoftSkillsScore(Float.valueOf(map.get("SOFT_SKILL_SCORE").toString()));
			
			if(map.get("CANDIDATE_ID") != null){
				int candidateId = Integer.valueOf(map.get("CANDIDATE_ID").toString());
				assessment.setCandidatedto(candidateDao.getCandidate(candidateId));
			}
			else{
				 //default value is null
				assessment.setCandidatedto(null);
			}
			
			listAssessment.add(assessment);
		}
		return listAssessment;
	}

	@Override
	public AssessmentDto getAssessment(int assessmentId) {
		sql = "select * from assessment_master where ASSESSMENT_ID = ?";
		Object obj[] = new Object[]{assessmentId};
		return jdbcTemplate.queryForObject(sql,obj,new AssesementRowMapper());
	}

	@Override
	public boolean addAssessment(AssessmentDto assessment) {
		sql = "insert into assessment_master values(assessment_id.nextVal,?,?,?,?,?,?,?)";
		Integer fk= null;
		if(assessment.getCandidatedto().getCandidateId() != 0){
			fk = assessment.getCandidatedto().getCandidateId();
		}
		Object obj[] = new Object[]{
				
			assessment.getRating(),
			assessment.getAptitudeScore(),
			assessment.getStatus(),
			assessment.getGroupDiscussionScore(),
			assessment.getSoftSkillsScore(),
			assessment.getProgramTestScore(),
			assessment.getCandidatedto().getCandidateId()
		};
		count = jdbcTemplate.update(sql,obj);
		if(count > 0)
			return true;
		return false;
	}

	@Override
	public boolean deleteAssessment(int assessmentId) {
		 sql = "delete from assessment_master where assessment_id= "+assessmentId;
		 count = jdbcTemplate.update(sql);
		 if(count > 0)
			 return true;
		return false;
	}

	@Override
	public boolean updateAssessment(int id,AssessmentDto assessment) {
		sql = "update assessment_master set "
				+ "rating = ?,"
				+ "aptitude_Score=?,"
				+ "status = ?,"
				+ "group_Discussion_Score = ?,"
				+ "soft_Skill_Score = ?,"
				+ "PROGRAM_TEST_SCORE = ? "
				+ "where assessment_Id = ?";
		
		Object[] obj = new Object[]{
				assessment.getRating(),
				assessment.getAptitudeScore(),
				assessment.getStatus(),
				assessment.getGroupDiscussionScore(),
				assessment.getSoftSkillsScore(),
				assessment.getProgramTestScore(),
				id
		};
		count = jdbcTemplate.update(sql,obj);
		if(count > 0)
			return true;
		return false;
	}

	private  class AssesementRowMapper implements RowMapper<AssessmentDto>{

		@Override
		public AssessmentDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			CandidateListDto candidate = null;
			if(rs.getObject("candidate_id") != null)
				candidate = candidateDao.getCandidate(rs.getInt("candidate_id"));

			AssessmentDto assessment = new AssessmentDto(
					rs.getInt("ASSESSMENT_ID"),
					rs.getFloat("rating"),
					rs.getFloat("APTITUDE_SCORE"),
					rs.getString("status"),
					rs.getFloat("GROUP_DISCUSSION_SCORE"),
					rs.getFloat("SOFT_SKILL_SCORE"),
					rs.getFloat("PROGRAM_TEST_SCORE"),
					candidate
					);
			return assessment;
		}
	}
}
