package az.maqa.embedded.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class User extends BaseEntity {

	private String name;

	private String surname;

	private int age;

	private String phone;

	@Column(name = "email", unique = true)
	private String email;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "postalCode" , column = @Column(name = "postal_code"))
	})
	private Address address;

	public User() {

	}

	public User(String name, String surname, int age, String phone, String email) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.phone = phone;
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public int getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
