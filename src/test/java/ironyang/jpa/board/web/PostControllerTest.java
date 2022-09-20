package ironyang.jpa.board.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import ironyang.jpa.board.domain.Post;
import ironyang.jpa.board.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@Slf4j
@WebMvcTest(PostController.class)
class PostControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    PostService postService;

    @Test
    void addPost() throws Exception {
        //given
        given(postService.addPost(any())).willReturn(1L);

        Post post = new Post("yang", "title", "content");
        ObjectMapper objectMapper = new ObjectMapper();
        String postJson = objectMapper.writeValueAsString(post);

        log.info("postJson = {}", postJson);

        //when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postJson));
        //then
        resultActions
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}