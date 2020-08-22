package az.maqa.fetchtype.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Doctor extends BaseEntity {

	private String name;

	private String surname;

	private int age;

	@OneToMany(mappedBy = "doctor" , fetch = FetchType.LAZY)
	private List<Laptop> laptops = new ArrayList<>();

	public Doctor() {

	}

	public Doctor(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
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

	public List<Laptop> getLaptops() {
		return laptops;
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

	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}

	@Override
	public String toString() {
		return "Doctor [name=" + name + ", surname=" + surname + ", age=" + age + "]";
	}

}
