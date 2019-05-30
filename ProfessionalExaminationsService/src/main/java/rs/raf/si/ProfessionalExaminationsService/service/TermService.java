package rs.raf.si.ProfessionalExaminationsService.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import rs.raf.si.ProfessionalExaminationsService.domain.dto.TermRequestDto;
import rs.raf.si.ProfessionalExaminationsService.domain.dto.TermResponseDto;
import rs.raf.si.ProfessionalExaminationsService.domain.dto.TermResultsRequestDto;

public interface TermService {
	
	Page<TermResponseDto> findAllByExam (Long examId, Pageable pageable);
	
	Page<TermResponseDto> findAllByAddress (Long addressId, Pageable pageable);
	
	Page<TermResponseDto> findAll (Pageable pageable);
	
	TermResponseDto save(TermRequestDto termRequestDto);
	
	TermResponseDto updateResults(TermResultsRequestDto results);
	
}
