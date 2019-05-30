package rs.raf.si.ProfessionalExaminationsService.service.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import rs.raf.si.ProfessionalExaminationsService.dao.ExamDao;
import rs.raf.si.ProfessionalExaminationsService.domain.Exam;
import rs.raf.si.ProfessionalExaminationsService.domain.dto.ExamRequestDto;
import rs.raf.si.ProfessionalExaminationsService.domain.dto.ExamResponseDto;
import rs.raf.si.ProfessionalExaminationsService.service.ExamService;

@Service
public class ExamServiceImpl implements ExamService {
	
	private ExamDao examDao;
	
	@Autowired
	public ExamServiceImpl(ExamDao examDao) {
		this.examDao = examDao;
	}

	@Override
	public Page<ExamResponseDto> findAll(Pageable pageable) {
		Page<Exam> page = examDao.findAll(pageable);
		return new PageImpl<>(page.stream().map(ExamResponseDto::new).collect(Collectors.toList()), pageable, page.getTotalElements());
	}

	@Override
	public ExamResponseDto findById(Long id) {
		Optional<Exam> optionalExam = examDao.findById(id);
		if(optionalExam.isEmpty()) {
			// TODO: Exception
			return null;
		}
		return new ExamResponseDto(optionalExam.get());
	}

	@Override
	public ExamResponseDto save(ExamRequestDto examRequestDto) {
		Exam exam = new Exam();
		exam.setDescription(examRequestDto.getDescription());
		exam.setScientificField(exam.getScientificField());
		exam.setTitle(exam.getTitle());
		examDao.save(exam);
		return new ExamResponseDto(exam);
	}

	@Override
	public ExamRequestDto update(Long examId, ExamRequestDto examRequestDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
