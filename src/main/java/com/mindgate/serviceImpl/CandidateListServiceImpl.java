package com.mindgate.serviceImpl;

import java.util.List;

import com.mindgate.dto.CandidateListDto;
import com.mindgate.service.CandidateListService;

public class CandidateListServiceImpl implements CandidateListService {

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
