package az.maqa.cache.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "bike_post")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class BikePost {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpa_sequence")
    @SequenceGenerator(name = "jpa_sequence")
    private Long id;

    private String title;

    public BikePost() {

    }

    public BikePost(String title) {
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

    @Override
    public String toString() {
        return "BikePost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
