package az.maqa.entitygraph.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedEntityGraph(
        name = "post-entity-graph-with-comment-users",
        attributeNodes = {
                @NamedAttributeNode("subject"),
                @NamedAttributeNode("user"),
                @NamedAttributeNode(value = "comments", subgraph = "comments-subgraph"),
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "comments-subgraph",
                        attributeNodes = {
                                @NamedAttributeNode("user")
                        }
                )
        }
)
@Entity
@Table(name = "online_post")
public class OnlinePost {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "jpa_sequence")
    private Long id;

    private String subject;

    @OneToMany(mappedBy = "post")
    private List<OnlineComment> comments = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private OnlineUser user;

    public OnlinePost() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<OnlineComment> getComments() {
        return comments;
    }

    public void setComments(List<OnlineComment> comments) {
        this.comments = comments;
    }

    public OnlineUser getUser() {
        return user;
    }

    public void setUser(OnlineUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "OnlinePost{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", comments=" + comments +
                ", user=" + user +
                '}';
    }
}
