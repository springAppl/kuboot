package spring.ku.boot.service;

import spring.ku.boot.criteria.ArticleCriteria;
import spring.ku.boot.criteria.SimplePage;
import spring.ku.boot.model.Article;

public interface ArticleReadService {
    Article findByID(Long id);

    SimplePage<Article> paging(ArticleCriteria articleCriteria);
}
