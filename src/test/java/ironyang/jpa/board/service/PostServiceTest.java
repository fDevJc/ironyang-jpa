package ironyang.jpa.board.service;

import ironyang.jpa.board.domain.Post;
import ironyang.jpa.board.repository.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @InjectMocks
    private PostService postService;

    @Mock
    private PostRepository postRepository;

    @Test
    void addPost() {
        //given
        Post post = new Post(1L,"","","");
        given(postRepository.save(any()))
                .willReturn(post);
        //when
        Long savedPostId = postService.addPost(post);

        //then
        Assertions.assertThat(savedPostId).isEqualTo(1L);
    }

    @Test
    void modifyPost() {
        //given

        //when

        //then
    }



}