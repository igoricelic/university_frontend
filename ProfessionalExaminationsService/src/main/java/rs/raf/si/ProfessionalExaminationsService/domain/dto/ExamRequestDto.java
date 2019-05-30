package rs.raf.si.ProfessionalExaminationsService.domain.dto;

public class ExamRequestDto {

	private Long id;

	private String title;

	private String scientificField;

	private String description;

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

}
