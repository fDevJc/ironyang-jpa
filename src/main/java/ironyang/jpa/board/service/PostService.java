package ironyang.jpa.board.service;

import ironyang.jpa.board.domain.Post;
import ironyang.jpa.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PostService {
    private final PostRepository postRepository;

    public Post findPost(Long id) {
        return postRepository.findById(id).get();
    }

    @Transactional
    public Long addPost(Post post) {
        return postRepository.save(post).getId();
    }

    @Transactional
    public Long modifyPost(Post post) {
        return post.getId();
    }

    @Transactional
    public Long deletePost(Long id) {
        Post post = postRepository.findById(id).get();
        postRepository.delete(post);
        return id;
    }
}
