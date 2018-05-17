package spring.ku.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    @Value("${STORAGE_PATH}")
    private String STORAGE_PATH;

    public static String IMAGE_HOST = "http://www.images.com/";

    @PostMapping
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {
        String uuid = UUID.randomUUID().toString();
        FileOutputStream fileWriter;
        try {
            fileWriter = new FileOutputStream(STORAGE_PATH + uuid);
        } catch (IOException e) {
            // TODO throw 500 Exception
            return "500 error";
        }
        try {
            fileWriter.write(file.getBytes());
        } catch (IOException e) {
            // TODO throw 500 Exception
            return "500 error";
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            // TODO throw 500 Exception
            return "500 error";
        }

        return IMAGE_HOST + uuid;
    }
}
