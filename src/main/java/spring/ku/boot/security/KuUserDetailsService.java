package spring.ku.boot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.ku.boot.model.User;
import spring.ku.boot.service.UserReadService;

import java.util.Objects;

@Service
public class KuUserDetailsService implements UserDetailsService {


    private final UserReadService userReadService;

    @Autowired
    public KuUserDetailsService(UserReadService userReadService) {
        this.userReadService = userReadService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User query = new User();
        query.setName(s);
        User user = userReadService.findByUser(query);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("name: " + s);
        }
        return new KuUserDetails(user);
    }
}
