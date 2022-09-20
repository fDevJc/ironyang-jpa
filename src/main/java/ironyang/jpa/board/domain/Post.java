package ironyang.jpa.board.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Post {
    @Id @GeneratedValue
    private Long id;
    private String writer;
    private String title;
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Post() {
    }

    public Post(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setPost(this);
    }
}
