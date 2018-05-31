package spring.ku.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spring.ku.boot.dao.ImageDAO;
import spring.ku.boot.model.Image;
import spring.ku.boot.service.ImageReadService;

@Service
@Component
public class ImageReadServiceImpl implements ImageReadService {

    @Autowired
    private ImageDAO imageDAO;


    @Override
    public Image findByID(Long id) {
        return imageDAO.findByID(id);
    }
}
