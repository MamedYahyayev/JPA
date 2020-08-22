package az.maqa.mappedsuperclass.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

@Entity
public class Student extends BaseEntity {

	@NotNull
	private String name;

	private String surname;

	private int age;

	private String email;

	private Date birthDate;

	@OneToMany(mappedBy = "student")
	private List<StudentCourse> studentCourseList = new ArrayList<>();

	public Student() {

	}

	public Student(String name, String surname, int age, String email, Date birthDate) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.email = email;
		this.birthDate = birthDate;
	}

	public List<StudentCourse> getStudentCourseList() {
		return studentCourseList;
	}

	public void setStudentCourseList(List<StudentCourse> studentCourseList) {
		this.studentCourseList = studentCourseList;
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

	public String getEmail() {
		return email;
	}

	public Date getBirthDate() {
		return birthDate;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
