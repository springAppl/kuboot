package spring.ku.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spring.ku.boot.dao.ArticleDAO;
import spring.ku.boot.model.Article;
import spring.ku.boot.service.ArticleReadService;

@Service
@Component
public class ArticleReadServiceImpl implements ArticleReadService {

    private ArticleDAO articleDAO;

    @Autowired
    public ArticleReadServiceImpl(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    @Override
    public Article findByID(Long id) {
        return articleDAO.findByID(id);
    }
}
