package ironyang.jpa.board.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Post {
    @Id @GeneratedValue
    private Long id;
    private String writer;
    private String title;
    private String content;

    @OneToMany(mappedBy = "post")
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
}
