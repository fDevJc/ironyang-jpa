package ironyang.jpa.board.service;

import ironyang.jpa.board.domain.Post;
import ironyang.jpa.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public Long addPost(Post post) {
        return postRepository.save(post).getId();
    }

    public Long modifyPost(Post post) {
        return post.getId();
    }

    public Post findPost(Long id) {
        return postRepository.findById(id).get();
    }

    public Long deletePost(Long id) {
        Post post = postRepository.findById(id).get();
        postRepository.delete(post);
        return id;
    }
}
