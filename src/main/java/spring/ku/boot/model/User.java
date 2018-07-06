package spring.ku.boot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 7079302429070890202L;

    private final static ObjectMapper objectMapper = new ObjectMapper();


    public User(User user) {
        setId(user.getId());
        setName(user.getName());
        setMobile(user.getMobile());
        setPassword(user.getPassword());
        setRoles(user.getRoles());
    }


    @Setter
    private Long id;

    @Setter
    private String name;

    @Setter
    private String mobile;

    @Setter
    private String password;

    private List<String> roles = Collections.emptyList();

    @JsonIgnore
    private String roleJson;

    public void setRoles(List<String> roles){
        this.roles = roles;
        try {
            this.roleJson = objectMapper.writeValueAsString(roles);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void setRoleJson(String roleJson){
        this.roleJson = roleJson;
        try {
            this.roles = objectMapper.readValue(roleJson, new TypeReference<List<String>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
