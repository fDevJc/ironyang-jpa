package ironyang.jpa.board.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Comment {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    private String writer;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Comment(String content) {
        this.content = content;
    }
}
