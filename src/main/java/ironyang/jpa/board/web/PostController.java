package ironyang.jpa.board.web;

import ironyang.jpa.board.domain.Post;
import ironyang.jpa.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    public String addPost(@RequestBody Post post) {
        postService.addPost(post);
        return "post ok";
    }

    @DeleteMapping("/post/{id}")
    public String deletePost(@PathVariable Long id) {
        return "delete ok";
    }
}
