package spring.ku.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.ku.boot.criteria.ItemCriteria;
import spring.ku.boot.criteria.SimplePage;
import spring.ku.boot.dao.ItemDAO;
import spring.ku.boot.dao.data.ItemRepo;
import spring.ku.boot.model.Item;
import spring.ku.boot.query.ItemPage;
import spring.ku.boot.service.ItemReadService;

@Service
public class ItemReadServiceImpl implements ItemReadService {

    private final ItemRepo itemRepo;

    private final ItemDAO itemDAO;

    @Autowired
    public ItemReadServiceImpl(ItemRepo itemRepo, ItemDAO itemDAO) {
        this.itemRepo = itemRepo;
        this.itemDAO = itemDAO;
    }


    public SimplePage<Item> page(ItemCriteria itemCriteria){
        return itemDAO.paging(itemCriteria);
    }
}
