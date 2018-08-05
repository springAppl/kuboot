package spring.ku.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import spring.ku.boot.criteria.ArticleCriteria;
import spring.ku.boot.criteria.SimplePage;
import spring.ku.boot.exception.WebException;
import spring.ku.boot.model.Article;
import spring.ku.boot.service.ArticleReadService;
import spring.ku.boot.service.ArticleWriteService;
import spring.ku.boot.util.UserUtil;

import java.util.Objects;

@RestController
@RequestMapping("/api/article")
public class ArticleController {


    @Autowired
    private ArticleWriteService articleWriteService;

    @Autowired
    private ArticleReadService articleReadService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping
    public Long post(@RequestBody Article article){
        article.setUserID(UserUtil.current().getId());
        return articleWriteService.create(article);
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping
    public Article put(@RequestBody Article article){
        // auth check
        Long memberID = UserUtil.current().getId();
        if (Objects.isNull(article.getId())) {
            article.setUserID(memberID);
            Long articleID = articleWriteService.create(article);
            article.setId(articleID);
        } else {
            articleWriteService.update(article);
        }
        return get(article.getId());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        Article article = articleReadService.findByID(id);
        if (Objects.isNull(article)) {
            throw new WebException("article.not.exist");
        }
        if (Objects.equals(UserUtil.current().getId(), article.getUserID()))
        // 逻辑删除
        articleWriteService.delete(id);
    }


    @GetMapping("{id}")
    public Article get(@PathVariable("id") Long id){
        return articleReadService.findByID(id);
    }

    @GetMapping("/paging")
    public SimplePage<Article> paging(Integer pageNo,
                                      Integer pageSize){
        return articleReadService.paging(new ArticleCriteria(pageNo, pageSize));
    }
}
