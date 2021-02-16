package az.maqa.lazyToOne.model;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;

@Entity
@Table(name = "car_post_details")
public class CarPostDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpa_sequence")
    private Long id;

    private String review;

    @OneToOne(fetch = FetchType.LAZY)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    @MapsId
    private CarPost post;

    public CarPostDetails() {

    }

    public CarPostDetails(String review) {
        this.review = review;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public CarPost getPost() {
        return post;
    }

    public void setPost(CarPost post) {
        this.post = post;
    }


}
