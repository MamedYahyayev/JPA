package az.maqa.oneToOne.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "medium_post")
public class MediumPost {

    private final Date createdOn;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpa_sequence")
    private Long id;
    private String title;

    @OneToOne(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private MediumPostDetails details;


    public MediumPost() {
        createdOn = new Date();
    }

    public Long getId() {
        return id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MediumPostDetails getDetails() {
        return details;
    }

    public void setDetails(MediumPostDetails details) {
        if (details == null) {
            if (this.details != null) {
                this.details.setPost(null);
            }
        } else {
            details.setPost(this);
        }
        this.details = details;
    }

    @Override
    public String toString() {
        return "MediumPost{" +
                "createdOn=" + createdOn +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", details=" + details +
                '}';
    }
}
