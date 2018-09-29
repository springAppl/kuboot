package spring.ku.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.ku.boot.dao.data.PageRepo;
import spring.ku.boot.model.Page;
import spring.ku.boot.service.PageWriteService;
import java.util.Optional;

@Service
public class PageWriteServiceImpl implements PageWriteService {

    private final PageRepo pageRepo;

    @Autowired
    public PageWriteServiceImpl(PageRepo pageRepo) {
        this.pageRepo = pageRepo;
    }

    @Override
    public Optional<Page> save(Page page) {
        return Optional.ofNullable(pageRepo.save(page));
    }

    @Override
    public void delete(String id) {
        pageRepo.delete(id);
    }
}
