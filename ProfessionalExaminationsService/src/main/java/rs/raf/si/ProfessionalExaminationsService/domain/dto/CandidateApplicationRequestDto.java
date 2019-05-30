package rs.raf.si.ProfessionalExaminationsService.domain.dto;

public class CandidateApplicationRequestDto {
	
	private Long id;
	
	private Long termId;
	
	private String candidateJmbg;
	
	public Long getId() {
		return id;
	}
	
	public Long getTermId() {
		return termId;
	}
	
	public String getCandidateJmbg() {
		return candidateJmbg;
	}

}
