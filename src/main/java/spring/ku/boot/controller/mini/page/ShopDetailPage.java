package spring.ku.boot.controller.mini.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.ku.boot.util.ResourceUtil;

import java.util.Objects;

@RestController
@RequestMapping("/api/shop-detail")
public class ShopDetailPage {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/{shopID}")
    public Object page(@PathVariable Long shopID){
        Object obj = stringRedisTemplate.opsForValue().get("index");
        if (Objects.isNull(obj)) {
            String index = ResourceUtil.classPath("restaurant.json");
            stringRedisTemplate.opsForValue().set("index", index);
            return index;
        }
        return obj;
    }
}
