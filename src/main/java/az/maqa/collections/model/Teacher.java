package az.maqa.collections.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity(name = "teacher")
@Table(name = "teacher")
public class Teacher extends BaseEntity {

	private String name;

	private String surname;

	private int age;

	@ElementCollection
	@JoinTable(name = "teacher_address", joinColumns = @JoinColumn(name = "teacher_id"))
	@GenericGenerator(name = "increment-gen", strategy = "increment")
	@CollectionId(columns = { @Column(name = "address_id") }, generator = "increment-gen", type = @Type(type = "long"))
	private Collection<Address> addresses = new ArrayList<>();

	// CollectionId and GenericGenerator don't support Set , They are support
	// Collection

	public Teacher() {

	}

	public Teacher(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	public Collection<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
