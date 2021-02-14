package az.maqa.orphanremoval.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stack_over_flow_post")
public class StackOverFlowPost {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "jpa_sequence")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    List<StackOverFlowPostComment> comments = new ArrayList<>();

    public StackOverFlowPost(){

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

    public List<StackOverFlowPostComment> getComments() {
        return comments;
    }

    public StackOverFlowPost addComment(StackOverFlowPostComment comment){
        comments.add(comment);
        comment.setPost(this);
        return this;
    }

    public StackOverFlowPost removeComment(StackOverFlowPostComment comment){
        comments.remove(comment);
        comment.setPost(null);
        return this;
    }

    public void setComments(List<StackOverFlowPostComment> comments) {
        this.comments = comments;
    }
}
