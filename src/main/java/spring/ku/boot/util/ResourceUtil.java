package spring.ku.boot.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import spring.ku.boot.exception.WebException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ResourceUtil {

    public static String classPath(String file){
        Resource resource = new ClassPathResource(file);
        if (!resource.exists()) {
            // TODO 日志
            throw new WebException();
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        } catch (IOException e) {

            throw new WebException();
        }
        StringBuffer message = new StringBuffer();
        String line;
        String defaultString;
        try {
            while ((line = br.readLine()) != null) {
                message.append(line);
            }
            defaultString = message.toString();
        } catch (IOException e) {
            throw new WebException();
        }
        return defaultString;
    }

}
