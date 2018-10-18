package spring.ku.boot;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
// 推荐单元测试类最好不要继承这个配置类，因为会把整个SpringContext启动起来，效率太低。
@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@TestPropertySource("classpath:/application-test.yaml")
public class KubootAppTest {

    @Autowired
    private TestRestTemplate restTemplate;

}