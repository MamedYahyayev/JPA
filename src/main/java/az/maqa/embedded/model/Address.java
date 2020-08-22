package az.maqa.embedded.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String country;

	private String city;

	private String street;

	private int postalCode;

	public Address() {

	}
	
	public Address(String country, String city, String street, int postalCode) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}


	
	
}
