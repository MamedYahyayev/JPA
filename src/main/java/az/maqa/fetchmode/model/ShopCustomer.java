package az.maqa.fetchmode.model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shop_customer")
public class ShopCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "jpa_sequence")
    private Long id;

    private String name;

    private String surname;

    @OneToMany(mappedBy = "shopCustomer", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @BatchSize(size = 5)
    private Set<ShopOrder> shopOrders = new HashSet<>();

    public ShopCustomer() {

    }

    public ShopCustomer(String name, String surname) {
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

    public Set<ShopOrder> getOrders() {
        return shopOrders;
    }

    public void setOrders(Set<ShopOrder> shopOrders) {
        this.shopOrders = shopOrders;
    }

    @Override
    public String toString() {
        return "ShopCustomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'';
    }
}
