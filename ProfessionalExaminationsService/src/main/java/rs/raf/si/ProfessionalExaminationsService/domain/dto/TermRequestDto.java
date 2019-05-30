package rs.raf.si.ProfessionalExaminationsService.domain.dto;

import java.util.Date;

public class TermRequestDto {
	
	private Long id;
	
	private Date dateAndTime;
	
	private Long addressId;
	
	private Long examId;
	
	
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
	
	public Long getAddressId() {
		return addressId;
	}
	
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	
	public Long getExamId() {
		return examId;
	}
	
	public void setExamId(Long examId) {
		this.examId = examId;
	}

}
