package com.mindgate.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.daoImpl.CandidateListDAOImpl;
import com.mindgate.dto.CandidateListDto;
import com.mindgate.service.CandidateListService;

@Service
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
	public boolean updateCandidate(int id,CandidateListDto candidateListDto) {
		return candidateDao.updateCandidate(id,candidateListDto);
	}

	@Override
	public boolean addCandidate(CandidateListDto candidateListDto) {
		return candidateDao.addCandidate(candidateListDto);
	}

}
