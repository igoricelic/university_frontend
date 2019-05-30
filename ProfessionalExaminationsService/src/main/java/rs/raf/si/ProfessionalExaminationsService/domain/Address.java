package rs.raf.si.ProfessionalExaminationsService.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String city;
	
	private String street;
	
	@Column(name = "house_number")
	private Long houseNumber;
	
	@Column(name = "post_code")
	private Long postCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Long getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(Long houseNumber) {
		this.houseNumber = houseNumber;
	}

	public Long getPostCode() {
		return postCode;
	}

	public void setPostCode(Long postCode) {
		this.postCode = postCode;
	}

}
