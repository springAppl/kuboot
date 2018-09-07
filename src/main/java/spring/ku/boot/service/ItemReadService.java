package spring.ku.boot.service;

import spring.ku.boot.criteria.ItemCriteria;
import spring.ku.boot.criteria.SimplePage;
import spring.ku.boot.model.Item;

public interface ItemReadService {

    SimplePage<Item> page(ItemCriteria itemCriteria);

    Item find(Long id);
}
