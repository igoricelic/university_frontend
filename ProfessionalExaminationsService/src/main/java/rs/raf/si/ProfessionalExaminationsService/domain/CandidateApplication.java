package rs.raf.si.ProfessionalExaminationsService.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import rs.raf.si.ProfessionalExaminationsService.domain.enums.StatusOfApplication;

@Entity
@Table(name = "candidate_application")
public class CandidateApplication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "jmbg")
	private String candidateJmbg;
	
	@Column(name = "date_of_application")
	private Date dateOfApplication;
	
	@Enumerated(EnumType.STRING)
	private StatusOfApplication status;
	
	@ManyToOne
	@JoinColumn(name = "term_id")
	private Term term;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDateOfApplication() {
		return dateOfApplication;
	}
	
	public void setDateOfApplication(Date dateOfApplication) {
		this.dateOfApplication = dateOfApplication;
	}
	
	public StatusOfApplication getStatus() {
		return status;
	}
	
	public void setStatus(StatusOfApplication status) {
		this.status = status;
	}
	
	public Term getTerm() {
		return term;
	}
	
	public void setTerm(Term term) {
		this.term = term;
	}
	
	public String getCandidateJmbg() {
		return candidateJmbg;
	}
	
	public void setCandidateJmbg(String candidateJmbg) {
		this.candidateJmbg = candidateJmbg;
	}

}
