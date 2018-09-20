package spring.ku.boot.dao.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import spring.ku.boot.model.Shop;

public interface ShopRepo extends PagingAndSortingRepository<Shop, Long> {
}
