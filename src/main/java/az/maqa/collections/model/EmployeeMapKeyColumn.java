package az.maqa.collections.model;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "employee_map_key_column")
public class EmployeeMapKeyColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "jpa_sequence")
    @SequenceGenerator(name = "jpa_sequence", initialValue = 5)
    private Long id;

    private String name;

    private String surname;

    @ElementCollection
    @CollectionTable(name = "employee_items", joinColumns = @JoinColumn(name = "emp_id" , referencedColumnName = "id"))
    @MapKeyColumn(name = "item_name")
    @Column(name = "quantity")
    private Map<String, Integer> items;

    public EmployeeMapKeyColumn() {

    }

    public EmployeeMapKeyColumn(String name, String surname, Map<String, Integer> items) {
        this.name = name;
        this.surname = surname;
        this.items = items;
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

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }
}
