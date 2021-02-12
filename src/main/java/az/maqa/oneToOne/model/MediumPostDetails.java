package az.maqa.oneToOne.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "medium_post_details")
public class MediumPostDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpa_sequence")
    private Long id;

    @Type(type = "text")
    private String details;

    @OneToOne
    @MapsId
    private MediumPost post;

    public Long getId() {
        return id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public MediumPost getPost() {
        return post;
    }

    public void setPost(MediumPost post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "MediumPostDetails{" +
                "id=" + id +
                ", details='" + details + '\'' +
                ", post=" + post +
                '}';
    }
}
