package spring.ku.boot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.ku.boot.criteria.ItemCriteria;
import spring.ku.boot.criteria.SimplePage;
import spring.ku.boot.model.Item;
import spring.ku.boot.service.ItemReadService;
import spring.ku.boot.service.ItemWriteService;
import java.util.Objects;

@Api(value = "/api/item", description = "商品创建")
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

    @ApiOperation(value = "商品的创建和更新", response = Item.class, tags = {"商品"})
    @PutMapping
    public Item save(@ApiParam("商品") @RequestBody Item item){
        // validate name price image
        if (Objects.isNull(item)) throw new IllegalArgumentException("item can't be null");
        if (Objects.isNull(item.getName())) throw new IllegalArgumentException("item name can't be null");
        return itemWriteService.save(item);
    }

    @ApiOperation(value = "商品分页查询", tags = {"商品"})
    @GetMapping("/paging")
    public SimplePage<Item> page(@ApiParam(name = "第几页", defaultValue = "1", required = false) @RequestParam(required = false, defaultValue = "1") Integer pageNumber,
                                 @RequestParam(required = false, defaultValue = "20") Integer pageSize,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) Long id){
        ItemCriteria itemCriteria = new ItemCriteria(pageNumber, pageSize);
        itemCriteria.setName(name);
        itemCriteria.setId(id);

        return itemReadService.page(itemCriteria);
    }

    @ApiOperation(value = "商品详情", tags = {"商品"})
    @GetMapping("/{id}")
    public Item detail(@PathVariable Long id) {
        return itemReadService.find(id);
    }

    @ApiOperation(value = "删除商品", tags = {"商品"})
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        itemWriteService.delete(id);
    }
}