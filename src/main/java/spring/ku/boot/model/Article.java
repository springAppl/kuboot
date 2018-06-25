package spring.ku.boot.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Getter
@ToString
public class Article implements Serializable {
    private static final long serialVersionUID = 2748991584338568633L;

    private final static ObjectMapper mapper = new ObjectMapper();

    @Setter
    private Long id;

    @Setter
    private String title;

    @Setter
    private String content;

    private List<String> tags;

    private String tagsJSON;

    public void setTags(List<String> tags){
        this.tags = tags;
        try {
            this.tagsJSON = mapper.writeValueAsString(tags);
        } catch (JsonProcessingException e) {
            // TODO 抛出一个数据格式错误
            log.debug("");
            throw new IllegalArgumentException("");
        }
    }

    public void setTagsJSON(String tagsJSON) {
        this.tagsJSON = tagsJSON;
        try {
            this.tags = mapper.readValue(tagsJSON, new TypeReference<List<String>>() {});
        } catch (IOException e) {
            // TODO 抛出一个数据格式错误
            log.debug("");
            throw new IllegalArgumentException("");
        }
    }

    @Setter
    private LocalDateTime createAt;

    @Setter
    private LocalDateTime updateAt;

    @Setter
    private Long userID;
}
