package com.mindgate.dao;

import java.util.List;

import com.mindgate.dto.CandidateListDto;

public interface CandidateListDAO {

    public List<CandidateListDto> getAllCandidate();
	
	public CandidateListDto getCandidate(int candidateId);
	
	public boolean deleteCandidate(int candidateId);
	
	public boolean updateCandidate(int id,CandidateListDto candidateListDto);
	
	public boolean addCandidate(CandidateListDto candidateListDto);
}
