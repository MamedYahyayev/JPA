package az.maqa.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "employee") // @Table(name = "employee") this class's name will be employee in database
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", length = 25, nullable = false) // nullable = false -- this column can not be empty ,
	private String name; // length = 25 this column can not be more than 25 characters

	@Column(name = "surname", updatable = false) // we can not update this column's values if this statement is
													// (updateable = false)
	private String surname;

	private int age;

	private int experience;

	@Column(name = "mail", unique = true) // it can not be same email in the table , if this statement is unique = true
	private String email;

	@Temporal(TemporalType.DATE)
	private Date birthOfDate; // TemporalType.DATE this means is birthOfDate contains of only Date Ex:
								// 15/5/1995
								// TemporalType.TIME this means is birthOfDate contains of only Time Ex:
								// 11:25:36
								// TemporalType.TIMESTAMP this means is birthdate contains of Date and Time .
								// Ex: 15/5/1995 11:25:36

	@Transient
	private double salary; // Transient this means is salary column will not be in the Employee table

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	
	public Employee() {
		
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	public Long getId() {
		return id;
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

	public int getExperience() {
		return experience;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getEmail() {
		return email;
	}

	public Date getBirthOfDate() {
		return birthOfDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirthOfDate(Date birthOfDate) {
		this.birthOfDate = birthOfDate;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + ", experience="
				+ experience + ", email=" + email + ", birthOfDate=" + birthOfDate + ", salary=" + salary + ", address="
				+ address + "]";
	}

}
