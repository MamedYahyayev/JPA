package az.maqa.flush.model;

import javax.persistence.*;

@Entity
@Table(name = "debt")
public class Debt {

    @Id
    private Long id;

    private String taxName;

    private Double debt;

    public Debt() {
    }

    public Debt(Long id, String taxName, Double debt) {
        this.id = id;
        this.taxName = taxName;
        this.debt = debt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public Double getDebt() {
        return debt;
    }

    public void setDebt(Double debt) {
        this.debt = debt;
    }

    @Override
    public String toString() {
        return "Debt{" +
                "id=" + id +
                ", taxName='" + taxName + '\'' +
                ", debt=" + debt +
                '}';
    }
}

