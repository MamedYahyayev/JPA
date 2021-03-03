package az.maqa.entitygraph.model;

import javax.persistence.*;

@Entity
@Table(name = "online_comment")
public class OnlineComment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "jpa_sequence")
    private Long id;

    private String reply;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private OnlinePost post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private OnlineUser user;

    public OnlineComment() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public OnlinePost getPost() {
        return post;
    }

    public void setPost(OnlinePost post) {
        this.post = post;
    }

    public OnlineUser getUser() {
        return user;
    }

    public void setUser(OnlineUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "OnlineComment{" +
                "id=" + id +
                ", reply='" + reply + '\'' +
                '}';
    }
}
