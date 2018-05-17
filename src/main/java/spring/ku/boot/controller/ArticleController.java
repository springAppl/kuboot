package spring.ku.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.ku.boot.model.Article;
import spring.ku.boot.service.ArticleReadService;
import spring.ku.boot.service.ArticleWriteService;

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
    public void put(@RequestBody Article article){
        articleWriteService.update(article);
    }

    @GetMapping("{id}")
    public Article get(@PathVariable("id") Long id){
        return articleReadService.findByID(id);
    }
}
