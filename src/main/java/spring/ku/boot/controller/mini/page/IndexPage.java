package spring.ku.boot.controller.mini.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import spring.ku.boot.logic.PageLogic;
import spring.ku.boot.model.Page;
import spring.ku.boot.util.ResourceUtil;
import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("/api/index")
public class IndexPage {

    private final StringRedisTemplate stringRedisTemplate;

    private final PageLogic pageLogic;

    @Autowired
    public IndexPage(StringRedisTemplate stringRedisTemplate, PageLogic pageLogic) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.pageLogic = pageLogic;
    }

    @GetMapping
    public Object index() throws IOException {
        Object obj = stringRedisTemplate.opsForValue().get("index");
        if (Objects.isNull(obj)) {
            return pageLogic.query("index");
        }
        return obj;
    }


    @PutMapping
    public String save(@RequestBody String str) {
        // 消息队列    include netposa/*.conf;
        stringRedisTemplate.opsForValue().set("index", str);
        Page query = new Page();
        query.setId("index");
        query.setContent(str);
        return pageLogic.save(query);
    }

    @PostMapping("/id")
    public Long componentID() {
        return stringRedisTemplate.boundValueOps("index:components:id").increment(1) + 2;
    }

    @PutMapping("/use/default")
    public Object template() throws IOException {
        String index = ResourceUtil.classPath("restaurant.json");
        stringRedisTemplate.opsForValue().set("index", index);
        Page query = new Page();
        query.setId("index");
        query.setContent(index);
        pageLogic.save(query);
        return index;
    }
}
