package spring.ku.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
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

    @Override
    public User findByUser(User user) {
        return userDAO.findByUser(user);
    }

    @Override
    public Boolean exist(User user) {
        if (StringUtils.hasText(user.getName()) && existName(user.getName())) {
            return true;
        }
        if (StringUtils.hasText(user.getMobile()) && existMobile(user.getMobile())) {
            return true;
        }
        return false;
    }

    private Boolean existName(String account) {
        User query = new User();
        query.setName(account);
        return Objects.nonNull(userDAO.findByUser(query));
    }

    private Boolean existMobile(String mobile){
        User query = new User();
        query.setMobile(mobile);
        return Objects.nonNull(userDAO.findByUser(query));
    }
}
