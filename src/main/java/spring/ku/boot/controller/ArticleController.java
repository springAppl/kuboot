package spring.ku.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.ku.boot.model.Article;
import spring.ku.boot.service.ArticleReadService;
import spring.ku.boot.service.ArticleWriteService;
import spring.ku.boot.util.UserUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@RestController
@RequestMapping("/api/article")
public class ArticleController {


    @Autowired
    private ArticleWriteService articleWriteService;

    @Autowired
    private ArticleReadService articleReadService;

    @PostMapping
    public Long post(@RequestBody Article article){
        return articleWriteService.create(article);
    }

    @PutMapping
    public void put(@RequestBody Article article, HttpServletRequest request){
        // auth check
        Long id = UserUtil.current(request);
        if (Objects.isNull(article.getId())) {
            article.setUserID(id);
            articleWriteService.update(article);
        }
        articleWriteService.update(article);
    }

    @GetMapping("{id}")
    public Article get(@PathVariable("id") Long id){
        return articleReadService.findByID(id);
    }
}
