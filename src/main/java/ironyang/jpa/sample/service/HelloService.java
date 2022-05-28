package ironyang.jpa.sample.service;

import ironyang.jpa.sample.domain.Hello;
import ironyang.jpa.sample.repository.HelloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class HelloService {
    private final HelloRepository helloRepository;

    @Transactional
    public Long save(Hello hello) {
        Hello save = helloRepository.save(hello);
        return save.getId();
    }
}
