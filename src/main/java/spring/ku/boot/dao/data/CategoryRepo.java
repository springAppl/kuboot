package spring.ku.boot.dao.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import spring.ku.boot.model.Category;

public interface CategoryRepo  extends PagingAndSortingRepository<Category, Long> {

}
