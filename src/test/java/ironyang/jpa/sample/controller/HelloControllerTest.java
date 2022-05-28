package ironyang.jpa.sample.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@WebMvcTest
class HelloControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    void hello() throws Exception {
        //given
        String name = "hello!";

        //when
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/hello")
                .param("name", name))
                .andDo(MockMvcResultHandlers.print());

        //then
        resultActions.andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }
}