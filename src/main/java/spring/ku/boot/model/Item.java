package spring.ku.boot.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.ToString;
import spring.ku.boot.dao.data.json.LocalDateTimeSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ToString
@Entity
@Table(name = "item")
public class Item implements Serializable {
    private static final long serialVersionUID = -2268208067647441480L;

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String image;

    private Integer price;

    @Column(name = "create_at")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createAt;

    @Column(name = "update_at")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateAt;
}
