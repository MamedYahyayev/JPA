package az.maqa.fetchmode.model;

import javax.persistence.*;

@Entity
@Table(name = "shop_order")
public class ShopOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "jpa_sequence")
    private Long id;


    private String name;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private ShopCustomer shopCustomer;

    public ShopOrder() {

    }

    public ShopOrder(String name) {
        this.name = name;
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

    public ShopCustomer getCustomer() {
        return shopCustomer;
    }

    public void setCustomer(ShopCustomer shopCustomer) {
        this.shopCustomer = shopCustomer;
    }

}
