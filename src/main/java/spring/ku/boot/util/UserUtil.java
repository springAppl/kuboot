package spring.ku.boot.util;

import org.springframework.security.core.context.SecurityContextHolder;
import spring.ku.boot.exception.WebException;
import spring.ku.boot.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class UserUtil {
    public static Long current(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (Objects.isNull(session)){
            throw new WebException(401);
        }
        Object id = session.getAttribute("id");
        if (Objects.isNull(id)){
            throw new WebException(401);
        }
        return (Long) id;
    }

    public static User current(){
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj instanceof User) {
            return (User) obj;
        } else {
            throw new WebException("用户未登录", 401);
        }
    }
}
