package ironyang.jpa.sample.acceptance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Commit
@Rollback(false)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloAcceptanceTest {
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