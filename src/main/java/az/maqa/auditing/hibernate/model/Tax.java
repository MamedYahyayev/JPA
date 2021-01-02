package az.maqa.auditing.hibernate.model;

import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "tax")
@Audited
public class Tax {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpa_sequence")
    private Long id;

    private String tax;

    public Tax() {

    }

    public Tax(String tax) {
        this.tax = tax;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "Tax{" +
                "id=" + id +
                ", tax='" + tax + '\'' +
                '}';
    }
}
