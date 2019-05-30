package rs.raf.si.ProfessionalExaminationsService.service.impl;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import rs.raf.si.ProfessionalExaminationsService.dao.CandidateApplicationDao;
import rs.raf.si.ProfessionalExaminationsService.dao.TermDao;
import rs.raf.si.ProfessionalExaminationsService.domain.CandidateApplication;
import rs.raf.si.ProfessionalExaminationsService.domain.Term;
import rs.raf.si.ProfessionalExaminationsService.domain.dto.CandidateApplicationRequestDto;
import rs.raf.si.ProfessionalExaminationsService.domain.dto.CandidateApplicationResponseDto;
import rs.raf.si.ProfessionalExaminationsService.domain.enums.StatusOfApplication;
import rs.raf.si.ProfessionalExaminationsService.service.CandidateApplicationService;

@Service
public class CandidateApplicationServiceImpl implements CandidateApplicationService {
	
	private TermDao termDao;
	
	private CandidateApplicationDao candidateApplicationDao;
	
	@Autowired
	public CandidateApplicationServiceImpl(TermDao termDao, CandidateApplicationDao candidateApplicationDao) {
		this.termDao = termDao;
		this.candidateApplicationDao = candidateApplicationDao;
	}

	@Override
	public Page<CandidateApplicationResponseDto> findAllByCandidate(String candidateJmbg, Pageable pageable) {
		Page<CandidateApplication> page = candidateApplicationDao.findByCandidateJmbg(candidateJmbg, pageable);
		return new PageImpl<>(page.stream().map(CandidateApplicationResponseDto::new).collect(Collectors.toList()), pageable, page.getTotalElements());
	}

	@Override
	public Page<CandidateApplicationResponseDto> findAll(Pageable pageable) {
		Page<CandidateApplication> page = candidateApplicationDao.findAll(pageable);
		return new PageImpl<>(page.stream().map(CandidateApplicationResponseDto::new).collect(Collectors.toList()), pageable, page.getTotalElements());
	}

	@Override
	public Page<CandidateApplicationResponseDto> findByTerm(Long termId, Pageable pageable) {
		Page<CandidateApplication> page = candidateApplicationDao.findByTerm_Id(termId, pageable);
		return new PageImpl<>(page.stream().map(CandidateApplicationResponseDto::new).collect(Collectors.toList()), pageable, page.getTotalElements());
	}

	@Override
	public CandidateApplicationResponseDto save(CandidateApplicationRequestDto candidateApplicationRequestDto) {
		Optional<Term> optionalTerm = termDao.findById(candidateApplicationRequestDto.getTermId());
		if(optionalTerm.isEmpty()) {
			// TODO: Exception
		}
		Term term = optionalTerm.get();
		String jmbg = candidateApplicationRequestDto.getCandidateJmbg();
		CandidateApplication candidateApplication = new CandidateApplication();
		candidateApplication.setCandidateJmbg(jmbg);
		candidateApplication.setStatus(StatusOfApplication.REGISTERED);
		candidateApplication.setDateOfApplication(new Date());
		candidateApplication.setTerm(term);
		candidateApplicationDao.save(candidateApplication);
		return new CandidateApplicationResponseDto(candidateApplication);
	}

}
