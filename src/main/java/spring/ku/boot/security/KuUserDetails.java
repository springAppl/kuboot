package spring.ku.boot.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import spring.ku.boot.model.User;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Collectors;

public class KuUserDetails extends User implements UserDetails, Serializable {

    private static final long serialVersionUID = -1124860786973266722L;

    public KuUserDetails(User user){
        super(user);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return super.getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role)).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
