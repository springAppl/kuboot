package spring.ku.boot.service;



import spring.ku.boot.criteria.UserCriteria;
import spring.ku.boot.model.User;

import java.util.List;

/**
 * @author lsf
 */
public interface UserReadService {
    /**
     * judge user login system
     * @param user user
     * @return boolean
     */
    boolean login(User user);

    User findByID(Long id);


    List<User> paging(UserCriteria userCriteria);
}
