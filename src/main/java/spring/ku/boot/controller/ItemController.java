package spring.ku.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.ku.boot.criteria.ItemCriteria;
import spring.ku.boot.criteria.SimplePage;
import spring.ku.boot.model.Item;
import spring.ku.boot.service.ItemReadService;
import spring.ku.boot.service.ItemWriteService;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    private final ItemWriteService itemWriteService;

    private final ItemReadService itemReadService;


    @Autowired
    public ItemController(ItemWriteService itemWriteService, ItemReadService itemReadService){
        this.itemWriteService = itemWriteService;
        this.itemReadService = itemReadService;
    }

    @PutMapping
    public Item save(@RequestBody Item item){
        return itemWriteService.save(item);
    }

    @GetMapping("/paging")
    public SimplePage<Item> page(@RequestParam(required = false, defaultValue = "1") Integer pageNumber,
                                 @RequestParam(required = false, defaultValue = "20") Integer pageSize,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) Long id){
        ItemCriteria itemCriteria = new ItemCriteria(pageNumber, pageSize);
        itemCriteria.setName(name);
        itemCriteria.setId(id);

        return itemReadService.page(itemCriteria);
    }
}