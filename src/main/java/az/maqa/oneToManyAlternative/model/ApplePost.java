package az.maqa.oneToManyAlternative.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name = "apple_post")
public class ApplePost {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpa_sequence")
    @SequenceGenerator(name = "jpa_sequence")
    private Long id;

    private String title;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn(name = "entry")
    private List<PostTag> tags = new ArrayList<>();

    public ApplePost() {

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

    public List<PostTag> getTags() {
        return tags;
    }

    public void setTags(List<PostTag> tags) {
        this.tags = tags;
    }



    public void removeTag(AppleTag tag) {
        for (Iterator<PostTag> iterator = tags.iterator(); iterator.hasNext(); ) {
            PostTag postTag = iterator.next();
            if (postTag.getPost().equals(this) && postTag.getTag().equals(tag)) {
                iterator.remove();
                postTag.getTag().getPosts().remove(postTag);
                postTag.setPost(null);
                postTag.setTag(null);
                break;
            }
        }
    }


    @Override
    public String toString() {
        return "ApplePost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
