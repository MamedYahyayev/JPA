package az.maqa.inheritance.defaultinheritance.tableperconcrete;

import javax.persistence.*;

@Entity
@Table(name = "person_concrete")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PersonConcrete {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;


    public PersonConcrete() {
    }

    public PersonConcrete(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
