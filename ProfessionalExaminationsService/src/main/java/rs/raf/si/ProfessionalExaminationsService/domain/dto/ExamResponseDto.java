package rs.raf.si.ProfessionalExaminationsService.domain.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import rs.raf.si.ProfessionalExaminationsService.domain.Exam;

@JsonInclude(Include.NON_NULL)
public class ExamResponseDto {

	private Long id;

	private String title;

	private String scientificField;

	private String description;
	
	private List<TermResponseDto> terms;
	
	public ExamResponseDto(Exam exam) {
		this.id = exam.getId();
		this.title = exam.getTitle();
		this.scientificField = exam.getScientificField();
		this.description = exam.getDescription();
		this.terms = exam.getTerms().stream().map(TermResponseDto::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getScientificField() {
		return scientificField;
	}

	public void setScientificField(String scientificField) {
		this.scientificField = scientificField;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<TermResponseDto> getTerms() {
		return terms;
	}

	public void setTerms(List<TermResponseDto> terms) {
		this.terms = terms;
	}

}
