package az.maqa.oneToManyAlternative.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "post_tag")
public class PostTag {

    @EmbeddedId
    private PostTagId id;

    @ManyToOne
    @MapsId("postId")
    private ApplePost post;

    @ManyToOne
    @MapsId("tagId")
    private AppleTag tag;

    public PostTag() {

    }

    public PostTag(ApplePost post, AppleTag tag) {
        this.post = post;
        this.tag = tag;
        this.id = new PostTagId(post.getId(), tag.getId());
    }


    public PostTagId getId() {
        return id;
    }

    public void setId(PostTagId id) {
        this.id = id;
    }

    public ApplePost getPost() {
        return post;
    }

    public void setPost(ApplePost post) {
        this.post = post;
    }

    public AppleTag getTag() {
        return tag;
    }

    public void setTag(AppleTag tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostTag postTag = (PostTag) o;
        return Objects.equals(post, postTag.post) && Objects.equals(tag, postTag.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(post, tag);
    }
}
