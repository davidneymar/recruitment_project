package com.mindgate.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.dao.AssessmentDao;
import com.mindgate.dto.AssessmentDto;

@Repository
public class AssessmentDaoImpl implements AssessmentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	String sql;
	@Override
	public List<AssessmentDto> getAllAssessment() {
		sql = "select * from assessment_master";
		
		Map<List<String,Object>> listAss = jdbcTemplate.queryForList(sql);
		
		return null;
	}

	@Override
	public AssessmentDto getPerAssessment(int assessmentId) {
		return null;
	}

	@Override
	public boolean deletePerAssessment(int assessmentId) {
		return false;
	}

	@Override
	public boolean updateAssessment(int assessmentId, AssessmentDto assessment) {
		return false;
	}

	@Override
	public boolean putPerAssessment(AssessmentDto assessment) {
		return false;
	}

}
