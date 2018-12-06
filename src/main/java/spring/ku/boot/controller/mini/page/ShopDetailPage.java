package spring.ku.boot.controller.mini.page;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import spring.ku.boot.exception.WebException;
import spring.ku.boot.logic.PageLogic;
import spring.ku.boot.model.Page;
import spring.ku.boot.model.UserShop;
import spring.ku.boot.security.KuUserDetails;
import spring.ku.boot.service.UserShopReadService;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/shop-detail")
public class ShopDetailPage {

    private final StringRedisTemplate stringRedisTemplate;

    private final PageLogic pageLogic;

    private final static String PREFIX = "shopDetail:";

    private final UserShopReadService userShopReadService;

    @Autowired
    public ShopDetailPage(StringRedisTemplate stringRedisTemplate,
                          PageLogic pageLogic,
                          UserShopReadService userShopReadService) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.pageLogic = pageLogic;
        this.userShopReadService = userShopReadService;
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

    @PutMapping
    public void save(
                       @ApiParam("模板") String content) {

        KuUserDetails principal = (KuUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserShop userShop = userShop(principal.getId());


        String pageID = PREFIX + userShop.getShopID();
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

    private UserShop userShop(Long userID){
        Optional<UserShop> optional = userShopReadService.findByUserID(userID);
        return optional.orElseThrow(() -> new WebException("请联系管理员绑定店铺"));
    }


    @GetMapping("/detail")
    public Object detail() {

        KuUserDetails principal = (KuUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserShop userShop = userShop(principal.getId());
        String pageID = PREFIX + userShop.getShopID();
        return pageLogic.query(pageID);
    }
}
