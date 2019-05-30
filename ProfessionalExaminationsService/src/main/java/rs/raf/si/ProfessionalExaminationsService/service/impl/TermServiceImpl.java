package rs.raf.si.ProfessionalExaminationsService.service.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import rs.raf.si.ProfessionalExaminationsService.dao.AddressDao;
import rs.raf.si.ProfessionalExaminationsService.dao.ExamDao;
import rs.raf.si.ProfessionalExaminationsService.dao.TermDao;
import rs.raf.si.ProfessionalExaminationsService.domain.Address;
import rs.raf.si.ProfessionalExaminationsService.domain.Exam;
import rs.raf.si.ProfessionalExaminationsService.domain.Term;
import rs.raf.si.ProfessionalExaminationsService.domain.dto.TermRequestDto;
import rs.raf.si.ProfessionalExaminationsService.domain.dto.TermResponseDto;
import rs.raf.si.ProfessionalExaminationsService.domain.dto.TermResultsRequestDto;
import rs.raf.si.ProfessionalExaminationsService.service.TermService;

@Service
public class TermServiceImpl implements TermService {
	
	private final ExamDao examDao;
	
	private final TermDao termDao;
	
	private final AddressDao addressDao;
	
	@Autowired
	public TermServiceImpl(TermDao termDao, AddressDao addressDao, ExamDao examDao) {
		this.termDao = termDao;
		this.examDao = examDao;
		this.addressDao = addressDao;
	}

	@Override
	public Page<TermResponseDto> findAllByExam(Long examId, Pageable pageable) {
		Page<Term> page = termDao.findByExam_Id(examId, pageable);
		return new PageImpl<>(page.stream().map(TermResponseDto::new).collect(Collectors.toList()), pageable, page.getTotalElements());
	}

	@Override
	public Page<TermResponseDto> findAllByAddress(Long addressId, Pageable pageable) {
		Page<Term> page = termDao.findByAddress_Id(addressId, pageable);
		return new PageImpl<>(page.stream().map(TermResponseDto::new).collect(Collectors.toList()), pageable, page.getTotalElements());
	}

	@Override
	public Page<TermResponseDto> findAll(Pageable pageable) {
		Page<Term> page = termDao.findAll(pageable);
		return new PageImpl<>(page.stream().map(TermResponseDto::new).collect(Collectors.toList()), pageable, page.getTotalElements());
	}

	@Override
	public TermResponseDto save(TermRequestDto termRequestDto) {
		Term term = new Term();
		Optional<Address> optionalAddress = addressDao.findById(termRequestDto.getAddressId());
		Optional<Exam> optionalExam = examDao.findById(termRequestDto.getExamId());
		if(optionalAddress.isEmpty() || optionalExam.isEmpty()) {
			// TODO: Example
		}
		term.setAddress(null);
		term.setDateAndTime(term.getDateAndTime());
		term.setExam(null);
		return null;
	}

	@Override
	public TermResponseDto updateResults(TermResultsRequestDto results) {
		// TODO Auto-generated method stub
		return null;
	}

}
