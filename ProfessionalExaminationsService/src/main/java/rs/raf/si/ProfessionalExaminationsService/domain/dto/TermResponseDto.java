package rs.raf.si.ProfessionalExaminationsService.domain.dto;

import java.util.Date;

import rs.raf.si.ProfessionalExaminationsService.domain.Term;

public class TermResponseDto {
	
	private Long id;
	
	private Date dateAndTime;
	
	private AddressResponseDto address;
	
	private String examName;
	
	public TermResponseDto(Term term) {
		this.id = term.getId();
		this.dateAndTime = term.getDateAndTime();
		this.address = new AddressResponseDto(term.getAddress());
		this.examName = term.getExam().getTitle();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDateAndTime() {
		return dateAndTime;
	}
	
	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	
	public AddressResponseDto getAddress() {
		return address;
	}
	
	public void setAddress(AddressResponseDto address) {
		this.address = address;
	}
	
	public String getExamName() {
		return examName;
	}
	
	public void setExamName(String examName) {
		this.examName = examName;
	}

}
