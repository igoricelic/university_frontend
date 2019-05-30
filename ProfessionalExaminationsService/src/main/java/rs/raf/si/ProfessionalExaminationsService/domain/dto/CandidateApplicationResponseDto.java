package rs.raf.si.ProfessionalExaminationsService.domain.dto;

import java.util.Date;

import rs.raf.si.ProfessionalExaminationsService.domain.CandidateApplication;

public class CandidateApplicationResponseDto {
	
	private Long id;
	
	private String jmbg;
	
	private Date dateOfApplication;
	
	private TermResponseDto term;
	
	public CandidateApplicationResponseDto(CandidateApplication application) {
		this.id = application.getId();
		this.jmbg = application.getCandidateJmbg();
		this.dateOfApplication = application.getDateOfApplication();
		this.term = new TermResponseDto(application.getTerm());
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getJmbg() {
		return jmbg;
	}
	
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	
	public Date getDateOfApplication() {
		return dateOfApplication;
	}
	
	public void setDateOfApplication(Date dateOfApplication) {
		this.dateOfApplication = dateOfApplication;
	}
	
	public TermResponseDto getTerm() {
		return term;
	}
	
	public void setTerm(TermResponseDto term) {
		this.term = term;
	}

}
