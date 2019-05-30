package rs.raf.si.ProfessionalExaminationsService.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import rs.raf.si.ProfessionalExaminationsService.domain.dto.CandidateApplicationRequestDto;
import rs.raf.si.ProfessionalExaminationsService.domain.dto.CandidateApplicationResponseDto;

public interface CandidateApplicationService {
	
	Page<CandidateApplicationResponseDto> findAllByCandidate(String candidateJmbg, Pageable pageable);
	
	Page<CandidateApplicationResponseDto> findAll(Pageable pageable);
	
	Page<CandidateApplicationResponseDto> findByTerm(Long termId, Pageable pageable);
	
	CandidateApplicationResponseDto save(CandidateApplicationRequestDto candidateApplicationRequestDto);

}
