package spring.ku.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.ku.boot.exception.WebException;
import spring.ku.boot.model.Image;
import spring.ku.boot.service.ImageReadService;
import spring.ku.boot.service.ImageWriteService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    @Autowired
    private ImageWriteService imageWriteService;

    @Autowired
    private ImageReadService imageReadService;

    @Value("${protocol:http://}")
    private String protocol;

    @Value("${image.host:127.0.0.1:8080}")
    private String host;

    @Value("${image.bucket:/api/image/}")
    private String bucket;


    @PostMapping
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {
        Image image = new Image();
        try {
            image.setData(file.getBytes());
        } catch (IOException e) {
            throw new WebException("image_destroy", 400);
        }
        Long imageID = imageWriteService.create(image);
        return protocol + host + bucket + imageID;
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
