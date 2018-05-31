package spring.ku.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spring.ku.boot.dao.ImageDAO;
import spring.ku.boot.model.Image;
import spring.ku.boot.service.ImageWriteService;

@Service
@Component
public class ImageWriteServiceImpl implements ImageWriteService {

    @Autowired
    private ImageDAO imageDAO;

    @Override
    public Long create(Image image) {
        imageDAO.create(image);
        return image.getId();
    }
}
