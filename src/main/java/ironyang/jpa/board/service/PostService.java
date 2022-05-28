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
}
