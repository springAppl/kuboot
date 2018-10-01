package spring.ku.boot.dao.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import spring.ku.boot.model.UserShop;

public interface UserShopRepo extends PagingAndSortingRepository<UserShop, Long> {

    UserShop findByUserID(Long userID);

}
