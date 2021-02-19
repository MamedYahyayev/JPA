package az.maqa.oneToManyAlternative.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "apple_tag")
public class AppleTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpa_sequence")
    @SequenceGenerator(name = "jpa_sequence")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostTag> posts = new ArrayList<>();

    public AppleTag() {

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

    public List<PostTag> getPosts() {
        return posts;
    }

    public void setPosts(List<PostTag> posts) {
        this.posts = posts;
    }


}
