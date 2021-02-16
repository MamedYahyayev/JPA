package az.maqa.lazyToOne.model;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;

@Entity
@Table(name = "car_post")
public class CarPost {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpa_sequence")
    private Long id;

    private String title;

    @OneToOne(
            mappedBy = "post",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @LazyToOne(LazyToOneOption.NO_PROXY)
    private CarPostDetails details;

    public CarPost() {

    }

    public CarPost(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CarPostDetails getDetails() {
        return details;
    }

    public void setDetails(CarPostDetails details) {
        this.details = details;
    }


    @Override
    public String toString() {
        return "CarPost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", details=" + details +
                '}';
    }
}
