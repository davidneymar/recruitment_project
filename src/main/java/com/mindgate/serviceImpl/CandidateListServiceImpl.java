package com.mindgate.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindgate.daoImpl.CandidateListDAOImpl;
import com.mindgate.dto.CandidateListDto;
import com.mindgate.service.CandidateListService;

public class CandidateListServiceImpl implements CandidateListService {

	@Autowired
	private CandidateListDAOImpl candidateDao;
	
	@Override
	public List<CandidateListDto> getAllCandidate() {
		return candidateDao.getAllCandidate();
	}

	@Override
	public CandidateListDto getCandidate(int candidateId) {
		return candidateDao.getCandidate(candidateId);
	}

	@Override
	public boolean deleteCandidate(int candidateId) {
		return candidateDao.deleteCandidate(candidateId);
	}

	@Override
	public boolean updateCandidate(CandidateListDto candidateListDto) {
		return candidateDao.updateCandidate(candidateListDto);
	}

	@Override
	public boolean addCandidate(CandidateListDto candidateListDto) {
		return candidateDao.addCandidate(candidateListDto);
	}

}
