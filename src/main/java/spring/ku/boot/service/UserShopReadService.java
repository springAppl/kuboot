package spring.ku.boot.service;

import spring.ku.boot.model.UserShop;

import java.util.Optional;

public interface UserShopReadService {
    Optional<UserShop> findByUserID(Long userID);
}
