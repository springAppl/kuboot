package spring.ku.boot.controller.mini.page;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import spring.ku.boot.logic.PageLogic;
import spring.ku.boot.model.Page;
import java.util.Objects;

@RestController
@RequestMapping("/api/shop-detail")
public class ShopDetailPage {

    private final StringRedisTemplate stringRedisTemplate;

    private final PageLogic pageLogic;

    private final static String PREFIX = "shopDetail:";

    @Autowired
    public ShopDetailPage(StringRedisTemplate stringRedisTemplate,
                          PageLogic pageLogic) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.pageLogic = pageLogic;
    }

    @GetMapping("/{shopID}")
    public String page(@PathVariable Long shopID){
        String pageID = PREFIX + shopID;
        String json = stringRedisTemplate.opsForValue().get(pageID);
        if (Objects.isNull(json)) {
            return pageLogic.query(pageID);
        }
        return json;
    }

    @PutMapping("/{shopID}")
    public void save(@ApiParam("店铺id") @PathVariable Long shopID,
                       @ApiParam("模板") String content) {
        String pageID = PREFIX + shopID;
        stringRedisTemplate.opsForValue().set(pageID, content);
        Page page = new Page();
        page.setId(pageID);
        page.setContent(content);
        pageLogic.save(page);
    }

    @PutMapping("/use/default/{id}")
    public Object useDefault(@ApiParam("店铺id") @PathVariable Long shopID) {
        String content = getDefault();
        String pageID = PREFIX + shopID;
        stringRedisTemplate.opsForValue().set(pageID, content);
        Page page = new Page();
        page.setId(pageID);
        page.setContent(content);
        pageLogic.save(page);
        return page(shopID);
    }

    private String getDefault() {
        String pageID = PREFIX + "default";
        String content = stringRedisTemplate.opsForValue().get(pageID);
        if (Objects.isNull(content)) {
            return pageLogic.query(pageID);
        }
        return content;
    }
}
