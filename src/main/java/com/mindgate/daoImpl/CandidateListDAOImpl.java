package com.mindgate.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mindgate.dao.CandidateListDAO;
import com.mindgate.dto.CandidateListDto;

@Repository
public class CandidateListDAOImpl implements CandidateListDAO {

	@Override
	public List<CandidateListDto> getAllCandidate() {
		return null;
	}

	@Override
	public CandidateListDto getCandidate(int candidateId) {
		return null;
	}

	@Override
	public boolean deleteCandidate(int candidateId) {
		return false;
	}

	@Override
	public boolean updateCandidate(int candidateId, CandidateListDto candidateListDto) {
		return false;
	}

	@Override
	public boolean addCandidate(CandidateListDto candidateListDto) {
		return false;
	}

}
