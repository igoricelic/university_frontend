package rs.raf.si.ProfessionalExaminationsService.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rs.raf.si.ProfessionalExaminationsService.domain.dto.TermRequestDto;
import rs.raf.si.ProfessionalExaminationsService.domain.dto.TermResponseDto;
import rs.raf.si.ProfessionalExaminationsService.domain.dto.TermResultsRequestDto;
import rs.raf.si.ProfessionalExaminationsService.service.TermService;

@RestController
@RequestMapping(path = "/term")
public class TermCtrl {

	private TermService termService;

	@Autowired
	public TermCtrl(TermService termService) {
		this.termService = termService;
	}

	@GetMapping(path = "/findByExam")
	public @ResponseBody Page<TermResponseDto> findAllByExam(Long examId, Pageable pageable) {
		return termService.findAllByExam(examId, pageable);
	}

	@GetMapping(path = "/findByAddress")
	public @ResponseBody Page<TermResponseDto> findAllByAddress(Long addressId, Pageable pageable) {
		return termService.findAllByAddress(addressId, pageable);
	}

	@GetMapping(path = "/findAll")
	public @ResponseBody Page<TermResponseDto> findAll(Pageable pageable) {
		return termService.findAll(pageable);
	}

	@PostMapping(path = "/save")
	public @ResponseBody TermResponseDto save(@RequestBody TermRequestDto termRequestDto) {
		return termService.save(termRequestDto);
	}

	@PutMapping(path = "/updateResults")
	public @ResponseBody TermResponseDto updateResults(TermResultsRequestDto results) {
		return termService.updateResults(results);
	}

}
