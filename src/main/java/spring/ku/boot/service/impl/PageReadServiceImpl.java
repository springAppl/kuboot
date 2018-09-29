package spring.ku.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.ku.boot.dao.data.PageRepo;
import spring.ku.boot.model.Page;
import spring.ku.boot.service.PageReadService;

import java.util.Optional;

@Service
public class PageReadServiceImpl implements PageReadService {

    private final PageRepo pageRepo;

    @Autowired
    public PageReadServiceImpl(PageRepo pageRepo) {
        this.pageRepo = pageRepo;
    }

    @Override
    public Optional<Page> query(String id) {
        return Optional.ofNullable(pageRepo.findOne(id));
    }
}
