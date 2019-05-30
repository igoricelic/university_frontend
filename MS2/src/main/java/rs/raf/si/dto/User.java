package rs.raf.si.dto;

public class User {
	
	private String firstName;
	
	private String lastName;
	
	private String fullName;
	
	private Integer randomNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(Integer randomNumber) {
		this.randomNumber = randomNumber;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", fullName=" + fullName + ", randomNumber="
				+ randomNumber + "]";
	}

}
