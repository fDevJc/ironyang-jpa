package ironyang.jpa.board.service;

import ironyang.jpa.board.domain.Post;
import ironyang.jpa.board.repository.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @InjectMocks
    private PostService postService;

    @Mock
    private PostRepository postRepository;

    @Test
    @DisplayName("[PostService][addPost] 게시글을 등록한다")
    void addPost() {
        //given
        Post post = new Post("writer","title","content");
        Long fakePostId = 1L;
        ReflectionTestUtils.setField(post, "id", fakePostId);
        given(postRepository.save(any()))
                .willReturn(post);
        //when
        Long savedPostId = postService.addPost(post);

        //then
        assertThat(savedPostId).isEqualTo(1L);
    }

    @Test
    @DisplayName("[PostService][modifyPost] 게시글을 수정한다")
    void modifyPost() {
        //given
        Post post = new Post("writer", "title", "content");
        Post modifyPost = new Post("modifyWriter", "modifyTitle", "modifyContent");
        Long fakePostId = 1L;
        ReflectionTestUtils.setField(post, "id", fakePostId);
        ReflectionTestUtils.setField(modifyPost, "id", fakePostId);

        given(postRepository.save(post))
                .willReturn(post);
        given(postRepository.findById(post.getId()))
                .willReturn(Optional.of(modifyPost));
        Long savedPostId = postService.addPost(post);

        //when
        Long modifiedPostId = postService.modifyPost(modifyPost);

        Post foundPost = postService.findPost(modifiedPostId);

        //then
        assertThat(foundPost.getWriter()).isEqualTo("modifyWriter");
        assertThat(foundPost.getTitle()).isEqualTo("modifyTitle");
        assertThat(foundPost.getContent()).isEqualTo("modifyContent");
    }
}