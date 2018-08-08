package spring.ku.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import spring.ku.boot.model.Category;
import spring.ku.boot.service.CategoryWriteService;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryWriteService categoryWriteService;

    @Autowired
    private RedisTemplate<Object, Object> categoryRedisTemplate;


    @PostMapping
    public Category create(@RequestBody Category category){
        return categoryWriteService.create(category);
    }

    @PostMapping("/index/page")
    public void indexPage(@RequestBody List<Category> categories){
        categoryRedisTemplate.boundValueOps("index:page:categories").set(categories);
    }

    @GetMapping("/index/page")
    public List<Category> indexPage(){
        return (List<Category>) categoryRedisTemplate.boundValueOps("index:page:category").get();
    }
}
