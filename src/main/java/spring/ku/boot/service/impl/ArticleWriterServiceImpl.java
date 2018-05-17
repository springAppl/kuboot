package spring.ku.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spring.ku.boot.dao.ArticleDAO;
import spring.ku.boot.model.Article;
import spring.ku.boot.service.ArticleWriteService;

@Service
@Component
public class ArticleWriterServiceImpl implements ArticleWriteService {

    private final ArticleDAO articleDAO;


    @Autowired
    public ArticleWriterServiceImpl(ArticleDAO articleDAO){
        this.articleDAO = articleDAO;
    }


    @Override
    public Long create(Article article) {
        articleDAO.create(article);
        return article.getId();
    }

    @Override
    public void update(Article article) {
        articleDAO.update(article);
    }
}
