package com.mindgate.daoImpl;

import java.io.IOException;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mindgate.dao.CandidateListDAO;
import com.mindgate.dto.CandidateListDto;
import com.mindgate.dto.JobDescriptionDto;

@Repository
public class CandidateListDAOImpl implements CandidateListDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private JobDescriptionDAOImpl jobDescDao;
	private String sql;
	private int count=0;

	@Override
	public List<CandidateListDto> getAllCandidate() {
		sql = "select * from candidate_list";//check table name is correct or not ?

		List<Map<String , Object>> listMapcandidate = jdbcTemplate.queryForList(sql);

		List<CandidateListDto> listcandidate = new ArrayList<CandidateListDto>();
		for(Map<String, Object> map : listMapcandidate) {
			CandidateListDto candidate = new CandidateListDto();
			candidate.setCandidateId(Integer.valueOf(map.get("candidate_id").toString()));
			candidate.setName(map.get("name").toString());
			candidate.setQualification(map.get("qualification").toString());
			candidate.setExperience(Float.valueOf(map.get("experience").toString()));   
			candidate.setEmail(map.get("email").toString());
			candidate.setPhoneNo(map.get("phone_no").toString());
			candidate.setPrimarySkill(map.get("primarySkill").toString());
			candidate.setSecondarySkills(map.get("secondarySkills").toString());
			try {
				Clob candResume = (Clob)map.get("resume");
				Reader r = candResume.getCharacterStream();
				int c=0,i=0;
				byte[] byteArr = null;

				while((i=r.read()) != -1) {
					byteArr[c] = (byte)i;
					c++;
				}
				candidate.setResume(byteArr);   // resume for Clob --> character large object
				Blob candImage = (Blob)map.get("photograph");
				candidate.setPhotograph(candImage.getBytes(
						           1,(int)candImage.length()));// image for Blob --> binary large Object
				
			}catch(IOException io) {
				System.out.println("exception occur from Reader "+io);
			}catch(SQLException sql) {
				System.out.println("exception occur from candImage.length() "+sql);
			}
			
			candidate.setDate((java.sql.Timestamp)map.get("date"));
			candidate.setStatus(map.get("status").toString());

			if(Integer.parseInt(map.get("job_desc_id").toString()) != 0)
				candidate.setJobDesc(jobDescDao.getJobDescription(Integer.valueOf(map.get("job_desc_id").toString())));
			else
				candidate.setJobDesc(new JobDescriptionDto());
			listcandidate.add(candidate);	
		}

		return listcandidate;
	}

	@Override
	public CandidateListDto getCandidate(int candidateId) {
		sql = "select * from candidate_list where candidate_id ="+candidateId;
		return jdbcTemplate.queryForObject(sql, new CandidateRowMapper());
	}

	@Override
	public boolean deleteCandidate(int candidateId) {
		sql = "delete from candidate_list where candidate_id = "+candidateId;
		count = jdbcTemplate.update(sql);
		if(count  > 0)
			return true;
		return false;
	}

	@Override
	public boolean updateCandidate(CandidateListDto candidateDto) {
		sql = "update job_description set candidate_id=?"
				+ "name=?"
				+ "qualification=?"
				+ "experience=?"
				+ "email=?"
				+ "phoneNo=?"
				+ "primarySkill=?"
				+ "secondarySkills=?"
				+ "resume=?"
				+ "photograph=?"
				+ "date=?"
				+ "status=?";
		Object[] obj = new Object[] {
				candidateDto.getCandidateId(),
				candidateDto.getName(),
				candidateDto.getQualification(),
				candidateDto.getExperience(),
				candidateDto.getEmail(),
				candidateDto.getPhoneNo(),
				candidateDto.getPrimarySkill(),
				candidateDto.getSecondarySkills(),
				candidateDto.getResume(),
				candidateDto.getPhotograph(),
				candidateDto.getDate(),
				candidateDto.getStatus()
		};
		count = jdbcTemplate.update(sql,obj);
		if(count > 0)
			return true;
		return false;
	}

	@Override
	public boolean addCandidate(CandidateListDto candidateDto) {
		sql = "insert into candidate_list values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] obj = new Object[] {
				candidateDto.getCandidateId(),
				candidateDto.getName(),
				candidateDto.getQualification(),
				candidateDto.getExperience(),
				candidateDto.getEmail(),
				candidateDto.getPhoneNo(),
				candidateDto.getPrimarySkill(),
				candidateDto.getSecondarySkills(),
				candidateDto.getResume(),
				candidateDto.getPhotograph(),
				candidateDto.getDate(),
				candidateDto.getStatus()
		};
		count = jdbcTemplate.update(sql,obj);
		if(count > 0)
			return true;
		return false;
	}
	
	private class CandidateRowMapper implements RowMapper<CandidateListDto>{
	
		@Override
		public CandidateListDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			JobDescriptionDto jobDescription = null;
			if(rs.getInt("job_desc_id") != 0)
				jobDescription = jobDescDao.getJobDescription(rs.getInt("job_desc_id"));
			CandidateListDto candidate = new CandidateListDto();
			candidate.setCandidateId(rs.getInt("candidateId"));
			candidate.setName(rs.getString("name"));
			candidate.setQualification(rs.getString("qualification"));
			candidate.setExperience(rs.getFloat("experience"));   
			candidate.setEmail(rs.getString("email"));
			candidate.setPhoneNo(rs.getString("phone_no"));
			candidate.setPrimarySkill(rs.getString("primarySkill"));
			candidate.setSecondarySkills(rs.getString("secondarySkills"));
			try {

				Clob clobResume = rs.getClob("resume");
				Reader r = clobResume.getCharacterStream();
				int i=0,c=0;
				byte[] byteArr = null;
			    while((i=r.read())!=-1) {
			    	byteArr[c] = (byte)i;
			    }
			    candidate.setResume(byteArr);
			    Blob blobImage = rs.getBlob("photograph");
			    candidate.setPhotograph(blobImage.getBytes(1, (int)blobImage.length()));
			    
			}catch(SQLException sql){
				System.out.println("exception occur blob.length()  "+sql);
			}catch(IOException io) {
				System.out.println("exception occur from Reader "+io);
			}
			
			candidate.setDate(rs.getTimestamp("date"));
			candidate.setStatus(rs.getString("status"));
			candidate.setJobDesc(jobDescription);
			
			return candidate;
		}
		
	}

}
