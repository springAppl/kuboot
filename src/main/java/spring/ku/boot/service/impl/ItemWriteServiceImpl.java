package spring.ku.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.ku.boot.dao.data.ItemRepo;
import spring.ku.boot.model.Item;
import spring.ku.boot.service.ItemWriteService;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class ItemWriteServiceImpl implements ItemWriteService {

    private final ItemRepo itemRepo;

    @Autowired
    public ItemWriteServiceImpl(ItemRepo itemRepo){
        this.itemRepo = itemRepo;
    }


    @Override
    public Item save(Item item) {
        if (Objects.isNull(item.getCreateAt())) {
            item.setCreateAt(LocalDateTime.now());
        }
        item.setUpdateAt(LocalDateTime.now());
        return itemRepo.save(item);
    }

    @Override
    public void delete(Long id) {
        itemRepo.delete(id);
    }
}
