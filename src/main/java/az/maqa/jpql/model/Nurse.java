package az.maqa.jpql.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import az.maqa.mappedsuperclass.model.BaseEntity;

@Entity
@Table(name = "nurse")
@NamedQueries({ 
	@NamedQuery(query = "Select n from Nurse n where n.id = :id", name = "find nurse by id"),
	@NamedQuery(query = "Select n from Nurse n where n.surname = :surname", name = "find nurse by surname") 
})

public class Nurse extends BaseEntity {

	private String name;

	private String surname;

	private int age;

	private double salary;

	public Nurse() {

	}

	public Nurse(String name, String surname, int age, double salary) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.salary = salary;

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

	public double getSalary() {
		return salary;
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

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Nurse [name=" + name + ", surname=" + surname + ", age=" + age + ", salary=" + salary + "]";
	}

}
