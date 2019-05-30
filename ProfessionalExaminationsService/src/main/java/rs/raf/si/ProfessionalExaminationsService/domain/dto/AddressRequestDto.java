package rs.raf.si.ProfessionalExaminationsService.domain.dto;

public class AddressRequestDto {

	private String city;

	private String street;

	private Long houseNumber;

	private Long postCode;

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
