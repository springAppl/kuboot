package spring.ku.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.ku.boot.exception.WebException;
import spring.ku.boot.model.Image;
import spring.ku.boot.service.ImageReadService;
import spring.ku.boot.service.ImageWriteService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    @Autowired
    private ImageWriteService imageWriteService;

    @Autowired
    private ImageReadService imageReadService;


    @PostMapping
    public Long singleFileUpload(@RequestParam("file") MultipartFile file) {
        String uuid = UUID.randomUUID().toString();
        Image image = new Image();
        try {
            image.setData(file.getBytes());
        } catch (IOException e) {
            throw new WebException("image_destroy", 400);
        }
        return imageWriteService.create(image);
    }

    @GetMapping("/{id}")
    public void image(HttpServletResponse response, @PathVariable("id") Long id) throws Exception {
        Image image = imageReadService.findByID(id);
        response.setContentType("image/png");
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(image.getData());
        outputStream.close();
    }
}
