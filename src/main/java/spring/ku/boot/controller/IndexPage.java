package spring.ku.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import spring.ku.boot.constan.IndexConfig;
import spring.ku.boot.exception.WebException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

@RestController
@RequestMapping("/api/index")
public class IndexPage {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping
    public Object index() throws IOException {
        Object obj = stringRedisTemplate.opsForValue().get("index");
        if (Objects.isNull(obj)) {
            String index = readFromFile("restaurant");
            stringRedisTemplate.opsForValue().set("index", index);
            return index;
        }
        return obj;
    }


    private String readFromFile(String key){
        StringBuilder stringBuilder = new StringBuilder(key);
        stringBuilder.append(".json");
        Resource resource = new ClassPathResource(stringBuilder.toString());


        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        } catch (IOException e) {

            throw new WebException();
        }
        StringBuffer message = new StringBuffer();
        String line;
        String defaultString;
        try {
            while ((line = br.readLine()) != null) {
                message.append(line);
            }
            defaultString = message.toString();
        } catch (IOException e) {
            throw new WebException();
        }
        return defaultString;
    }


    @PutMapping
    public void update(@RequestBody String str) {
        stringRedisTemplate.opsForValue().set("index", str);
    }

    @PostMapping("/id")
    public Long componentID() {
        return stringRedisTemplate.boundValueOps("index:components:id").increment(1) + 2;
    }

    @PutMapping("/template")
    public Object template() throws IOException {
        String index = readFromFile("restaurant");
        stringRedisTemplate.opsForValue().set("index", index);
        return index;
    }

    @PutMapping("/template/{id}")
    public Object change(@PathVariable String id){
        if (!IndexConfig.templates.contains(id)){
            throw new WebException("模板不存在", 401);
        }
        String index = readFromFile(id);
        stringRedisTemplate.opsForValue().set("index", index);
        return index;
    }
}
