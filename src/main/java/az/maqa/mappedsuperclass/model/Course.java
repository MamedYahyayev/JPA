package az.maqa.mappedsuperclass.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Course extends BaseEntity {

	private String courseName;

	private double price;

	private int graduatedTime;

	@OneToMany(mappedBy = "course")
	private List<StudentCourse> studentCourseList = new ArrayList<>();

	public Course() {

	}

	public Course(String courseName, Double price, int graduatedTime) {
		this.courseName = courseName;
		this.price = price;
		this.graduatedTime = graduatedTime;
	}

	public List<StudentCourse> getStudentCourseList() {
		return studentCourseList;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setStudentCourseList(List<StudentCourse> studentCourseList) {
		this.studentCourseList = studentCourseList;
	}

	public String getCourseName() {
		return courseName;
	}

	public int getGraduatedTime() {
		return graduatedTime;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setGraduatedTime(int graduatedTime) {
		this.graduatedTime = graduatedTime;
	}

}
