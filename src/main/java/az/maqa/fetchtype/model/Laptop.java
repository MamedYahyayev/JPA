package az.maqa.fetchtype.model;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Laptop extends BaseEntity {

	private String laptopName;

	private double price;

	@Type(type="text") // This annotations create description column with TEXT data type, default: VARCHAR.
	private String description; // we replace default data type with TEXT

	@Type(type = "yes_no") // default type is boolean and its values are true and false, we replace true and false with yes and no
	private Boolean isAvailable;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAvailable() {
		return isAvailable;
	}

	public void setAvailable(Boolean available) {
		isAvailable = available;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Laptop [laptopName=" + laptopName + ", price=" + price + ", doctor=" + doctor + "]";
	}

}
