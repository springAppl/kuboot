package spring.ku.boot.controller.mini.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import spring.ku.boot.constan.IndexConfig;
import spring.ku.boot.exception.WebException;
import spring.ku.boot.util.ResourceUtil;
import java.io.IOException;
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
            String index = ResourceUtil.classPath("restaurant.json");
            stringRedisTemplate.opsForValue().set("index", index);
            return index;
        }
        return obj;
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
        String index = ResourceUtil.classPath("restaurant.json");
        stringRedisTemplate.opsForValue().set("index", index);
        return index;
    }

    @PutMapping("/template/{id}")
    public Object change(@PathVariable String id){
        if (!IndexConfig.templates.contains(id)){
            throw new WebException("模板不存在", 401);
        }
        String index = ResourceUtil.classPath(id);
        stringRedisTemplate.opsForValue().set("index", index);
        return index;
    }
}
