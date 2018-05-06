package spring.ku.boot.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = 7079302429070890202L;

    private Long id;

    private String name;

    private String mobile;

    private String password;
}
