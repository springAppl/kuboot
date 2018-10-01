package spring.ku.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.ku.boot.dao.data.UserShopRepo;
import spring.ku.boot.model.UserShop;
import spring.ku.boot.service.UserShopReadService;

import java.util.Optional;

@Service
public class UserShopReadServiceImpl implements UserShopReadService {

    private final UserShopRepo userShopRepo;

    @Autowired
    public UserShopReadServiceImpl(UserShopRepo userShopRepo){
        this.userShopRepo = userShopRepo;
    }

    @Override
    public Optional<UserShop> findByUserID(Long userID) {
        return Optional.ofNullable(userShopRepo.findByUserID(userID));
    }
}
