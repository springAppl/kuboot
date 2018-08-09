package spring.ku.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/api/index")
public class IndexPage {

//    @Autowired
//    private Index index;

    @Value(value = "classpath:components.json")
    private Resource resource;

    @GetMapping
    public Object index() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        StringBuffer message=new StringBuffer();
        String line = null;
        while((line = br.readLine()) != null) {
            message.append(line);
        }
        String defaultString = message.toString();
        return defaultString;
    }
}
