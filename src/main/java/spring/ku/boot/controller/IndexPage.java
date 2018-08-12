package spring.ku.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

@RestController
@RequestMapping("/api/index")
public class IndexPage {

    @Value(value = "classpath:components.json")
    private Resource resource;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping
    public Object index() throws IOException {
        Object obj = stringRedisTemplate.opsForValue().get("index");
        if (Objects.isNull(obj)) {
            String index = readFromFile();
            stringRedisTemplate.opsForValue().set("index", index);
            return index;
        }
        return obj;
    }


    private String readFromFile() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        StringBuffer message=new StringBuffer();
        String line = null;
        while((line = br.readLine()) != null) {
            message.append(line);
        }
        String defaultString = message.toString();
        return defaultString;
    }


    @PutMapping
    public void update(@RequestBody String str){
        stringRedisTemplate.opsForValue().set("index", str);
    }
}
