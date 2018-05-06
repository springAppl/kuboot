package spring.ku.boot.dao;

import org.springframework.stereotype.Repository;
import spring.ku.boot.model.User;

@Repository
public class UserDAO extends BaseDao<User> {

    public User findByUser(User user) {
        return getSqlSession().selectOne(mapperName("findByUser"), user);
    }

}
