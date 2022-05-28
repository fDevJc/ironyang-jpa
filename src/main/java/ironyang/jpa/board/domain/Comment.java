package ironyang.jpa.board.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

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
}
