package rs.raf.si.ProfessionalExaminationsService.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "term")
public class Term {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "date_and_time")
	private Date dateAndTime;
	
	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
	@ManyToOne
	@JoinColumn(name = "exam_id")
	private Exam exam;
	
	@OneToMany(mappedBy = "term")
	private List<CandidateApplication> candidates = new ArrayList<>();

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public List<CandidateApplication> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<CandidateApplication> candidates) {
		this.candidates = candidates;
	}

}
