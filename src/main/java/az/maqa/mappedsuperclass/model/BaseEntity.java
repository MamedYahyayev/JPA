package az.maqa.mappedsuperclass.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import net.bytebuddy.implementation.bind.annotation.Default;

@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	private Integer active = 1;

	public Long getId() {
		return id;
	}

	public Integer getActive() {
		return active;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

}
