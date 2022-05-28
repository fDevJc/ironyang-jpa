package ironyang.jpa.sample.controller;

import ironyang.jpa.sample.domain.Hello;
import ironyang.jpa.sample.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HelloController {
    private final HelloService helloService;

    @PostMapping("/hello")
    public String save(@ModelAttribute Hello hello) {
        Long savedId = helloService.save(hello);
        return "ok!! id: "+savedId.toString();
    }
}
