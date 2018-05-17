package spring.ku.boot.service;

import spring.ku.boot.model.Article;

public interface ArticleReadService {
    Article findByID(Long id);
}
