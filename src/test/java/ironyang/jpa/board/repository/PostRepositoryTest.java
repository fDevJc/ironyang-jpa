package ironyang.jpa.board.repository;

import ironyang.jpa.board.domain.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @Test
    void save() {
        //given
        Post post = new Post("yang", "title", "content");
        postRepository.save(post);

        //when
        Post foundPost = postRepository.findById(post.getId()).get();

        //then
        assertThat(foundPost.getWriter()).isEqualTo(post.getWriter());
        assertThat(foundPost.getTitle()).isEqualTo(post.getTitle());
        assertThat(foundPost.getContent()).isEqualTo(post.getContent());
    }

    @Test
    void findAll() {
        //given
        Post post1 = new Post("yang", "title1", "content1");
        Post post2 = new Post("yang", "title2", "content2");
        postRepository.save(post1);
        postRepository.save(post2);

        //when
        List<Post> posts = postRepository.findAll();

        //then
        assertThat(posts.size()).isEqualTo(2);
        assertThat(posts).containsExactly(post1, post2);
    }
}