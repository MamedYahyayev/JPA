package az.maqa.model.oneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String surname; 
	
	private int age;
	
	@OneToMany(mappedBy = "customer")
	private List<Product> products = new ArrayList<Product>();
	
	
	public Customer() {

	}

	public Customer(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	
	public void addProduct(Product product) {
		this.products.add(product);
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
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

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + ", products="
				+ products + "]";
	}
	
	
	
	
	
	
	
}
