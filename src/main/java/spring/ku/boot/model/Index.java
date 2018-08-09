package spring.ku.boot.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

//@Component
//@ConfigurationProperties("index")
@Data
public class Index {
    List<Map<String, Object>> components;
}
