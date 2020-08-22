package az.maqa.fetchtype.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Laptop extends BaseEntity {

	private String laptopName;

	private double price;

	@ManyToOne
	private Doctor doctor;

	public Laptop() {
		// TODO Auto-generated constructor stub
	}

	public Laptop(String laptopName, double price) {
		this.laptopName = laptopName;
		this.price = price;
	}

	public String getLaptopName() {
		return laptopName;
	}

	public double getPrice() {
		return price;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Laptop [laptopName=" + laptopName + ", price=" + price + ", doctor=" + doctor + "]";
	}

}
