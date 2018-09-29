package spring.ku.boot.dao.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import spring.ku.boot.model.Page;

public interface PageRepo extends PagingAndSortingRepository<Page, String> {
}
