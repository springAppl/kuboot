package spring.ku.boot.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString
@Entity
@Table(name = "category")
public class Category implements Serializable {

    private static final long serialVersionUID = -8822742261963577473L;

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(name = "image_url")
    private String imageURL;
}
