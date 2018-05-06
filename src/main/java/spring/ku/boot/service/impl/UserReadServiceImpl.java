package spring.ku.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.ku.boot.criteria.UserCriteria;
import spring.ku.boot.dao.UserDAO;
import spring.ku.boot.model.User;
import spring.ku.boot.service.UserReadService;

import java.util.List;
import java.util.Objects;

/**
 * @author lsf
 */
@Service
public class UserReadServiceImpl implements UserReadService{



    private final UserDAO userDAO;

    @Autowired
    public UserReadServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public boolean login(User user) {
        User query = userDAO.findByUser(user);
        if (Objects.isNull(query)) {
            return false;
        }
        return Objects.equals(query.getPassword(), user.getPassword());
    }

    @Override
    public User findByID(Long id) {
        return userDAO.findByID(id);
    }

    @Override
    public List<User> paging(UserCriteria userCriteria) {
        return userDAO.paging(userCriteria);
    }
}
