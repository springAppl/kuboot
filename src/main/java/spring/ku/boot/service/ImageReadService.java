package spring.ku.boot.service;

import spring.ku.boot.model.Image;

public interface ImageReadService {

    Image findByID(Long id);
}
