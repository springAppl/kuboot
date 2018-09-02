package spring.ku.boot.dao.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import spring.ku.boot.model.Item;

public interface ItemRepo extends PagingAndSortingRepository<Item, Long> {
}
