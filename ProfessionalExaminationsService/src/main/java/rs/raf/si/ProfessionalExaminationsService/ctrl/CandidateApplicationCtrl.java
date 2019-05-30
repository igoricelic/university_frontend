package rs.raf.si.ProfessionalExaminationsService.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rs.raf.si.ProfessionalExaminationsService.domain.dto.CandidateApplicationRequestDto;
import rs.raf.si.ProfessionalExaminationsService.domain.dto.CandidateApplicationResponseDto;
import rs.raf.si.ProfessionalExaminationsService.service.CandidateApplicationService;

@RestController
@RequestMapping(path = "/application")
public class CandidateApplicationCtrl {

	private CandidateApplicationService candidateApplicationService;

	@Autowired
	public CandidateApplicationCtrl(CandidateApplicationService candidateApplicationService) {
		this.candidateApplicationService = candidateApplicationService;
	}

	@GetMapping(path = "/findByCandidate")
	public @ResponseBody Page<CandidateApplicationResponseDto> findAllByCandidate(@RequestParam String candidateJmbg, Pageable pageable) {
		return candidateApplicationService.findAllByCandidate(candidateJmbg, pageable);
	}

	@GetMapping(path = "/findAll")
	public @ResponseBody Page<CandidateApplicationResponseDto> findAll(Pageable pageable) {
		return candidateApplicationService.findAll(pageable);
	}

	@GetMapping(path = "/findByTerm")
	public @ResponseBody Page<CandidateApplicationResponseDto> findByTerm(Long termId, Pageable pageable) {
		return candidateApplicationService.findByTerm(termId, pageable);
	}

	@PostMapping(path = "/save")
	public @ResponseBody CandidateApplicationResponseDto save(@RequestBody CandidateApplicationRequestDto candidateApplicationRequestDto) {
		return candidateApplicationService.save(candidateApplicationRequestDto);
	}

}
