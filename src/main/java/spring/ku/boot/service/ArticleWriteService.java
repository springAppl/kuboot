package spring.ku.boot.service;


import spring.ku.boot.model.Article;

public interface ArticleWriteService {
    Long create(Article article);
    void update(Article article);
    void delete(Long id);
}
