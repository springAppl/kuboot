package spring.ku.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        properties = "application-test.yaml",
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class KubootAppTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void name(){
        ResponseEntity<String> resp = testRestTemplate.getForEntity("/api/test/name", String.class);
        System.out.println(resp.getBody());
    }
}
