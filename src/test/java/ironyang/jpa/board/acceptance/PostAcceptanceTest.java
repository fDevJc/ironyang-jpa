package ironyang.jpa.board.acceptance;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@Transactional
public class PostAcceptanceTest {

    @LocalServerPort
    int port;

    @BeforeEach
    void beforeEach() {
        if (RestAssured.port == RestAssured.UNDEFINED_PORT) {
            RestAssured.port = port;
        }
    }

    @Test
    @DisplayName("[AcceptanceTest] 사용자가 게시글을 등록한다")
    void addPost() {
        //given
        Map<String, String> params = new HashMap<>();
        params.put("title", "title11");
        params.put("content", "content11");
        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .body(params)
                .contentType(ContentType.JSON)
                .when()
                .post("/posts")
                .then().log().all()
                .extract();

        //when

        //then
        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED);
    }
}
