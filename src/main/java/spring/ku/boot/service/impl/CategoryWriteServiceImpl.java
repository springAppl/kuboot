package spring.ku.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.ku.boot.dao.data.CategoryRepo;
import spring.ku.boot.model.Category;
import spring.ku.boot.service.CategoryWriteService;

@Service
public class CategoryWriteServiceImpl implements CategoryWriteService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category create(Category category) {
        return categoryRepo.save(category);
    }
}
