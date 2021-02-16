package az.maqa.cache.model;

import javax.persistence.*;

@Entity
@Table(name = "bike_comments")
public class BikeComments {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpa_sequence")
    @SequenceGenerator(name = "jpa_sequence")
    private Long id;

    private String comment;

    public BikeComments() {

    }

    public BikeComments(String comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "BikeComments{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
