package az.maqa.orphanremoval.model;

import javax.persistence.*;

@Entity
@Table(name = "stack_over_flow_post_comment")
public class StackOverFlowPostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "jpa_sequence")
    private Long id;

    private String review;

    @ManyToOne(fetch = FetchType.LAZY)
    private StackOverFlowPost post;

    public StackOverFlowPostComment() {

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

    public StackOverFlowPost getPost() {
        return post;
    }

    public void setPost(StackOverFlowPost post) {
        this.post = post;
    }
}
