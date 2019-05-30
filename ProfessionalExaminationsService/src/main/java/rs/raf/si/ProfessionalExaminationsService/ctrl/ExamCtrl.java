package rs.raf.si.ProfessionalExaminationsService.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rs.raf.si.ProfessionalExaminationsService.domain.dto.ExamRequestDto;
import rs.raf.si.ProfessionalExaminationsService.domain.dto.ExamResponseDto;
import rs.raf.si.ProfessionalExaminationsService.service.ExamService;

@RestController
@RequestMapping(path = "/exam")
public class ExamCtrl {
	
	private ExamService examService;
	
	@Autowired
	public ExamCtrl(ExamService examService) {
		this.examService = examService;
	}
	
	@GetMapping(path = "/findAll")
	public @ResponseBody Page<ExamResponseDto> findAll(Pageable pageable) {
		return examService.findAll(pageable);
	}

	@GetMapping(path = "/findById")
	public @ResponseBody ExamResponseDto findById(Long id) {
		return examService.findById(id);
	}

	@PostMapping(path = "/save")
	public @ResponseBody ExamResponseDto save(@RequestBody ExamRequestDto examRequestDto) {
		return examService.save(examRequestDto);
	}

	@PutMapping(path = "/update")
	public @ResponseBody ExamRequestDto update(@RequestParam Long examId, @RequestBody ExamRequestDto examRequestDto) {
		return examService.update(examId, examRequestDto);
	}

}
