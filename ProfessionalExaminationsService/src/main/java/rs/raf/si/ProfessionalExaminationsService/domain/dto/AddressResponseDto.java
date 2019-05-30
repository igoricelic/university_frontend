package rs.raf.si.ProfessionalExaminationsService.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import rs.raf.si.ProfessionalExaminationsService.domain.Address;

@JsonInclude(Include.NON_NULL)
public class AddressResponseDto {
	
	private Long id;

	private String city;

	private String street;

	private Long houseNumber;

	private Long postCode;
	
	public AddressResponseDto(Address address) {
		this.id = address.getId();
		this.city = address.getCity();
		this.street = address.getStreet();
		this.houseNumber = address.getHouseNumber();
		this.postCode = address.getPostCode();
	}

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
