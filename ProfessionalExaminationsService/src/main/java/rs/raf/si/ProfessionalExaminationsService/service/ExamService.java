package rs.raf.si.ProfessionalExaminationsService.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import rs.raf.si.ProfessionalExaminationsService.domain.dto.ExamRequestDto;
import rs.raf.si.ProfessionalExaminationsService.domain.dto.ExamResponseDto;

public interface ExamService {

	Page<ExamResponseDto> findAll(Pageable pageable);

	ExamResponseDto findById(Long id);

	ExamResponseDto save(ExamRequestDto examRequestDto);

	ExamRequestDto update(Long examId, ExamRequestDto examRequestDto);

}
