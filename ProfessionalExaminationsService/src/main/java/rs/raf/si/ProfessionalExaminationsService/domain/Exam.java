package rs.raf.si.ProfessionalExaminationsService.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "exam")
public class Exam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	@Column(name = "scientific_field")
	private String scientificField;
	
	private String description;
	
	@OneToMany(mappedBy = "exam")
	private List<Term> terms = new ArrayList<>();
	
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
	
	public List<Term> getTerms() {
		return terms;
	}
	
	public void setTerms(List<Term> terms) {
		this.terms = terms;
	}

}
