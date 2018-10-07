package spring.ku.boot.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import spring.ku.boot.security.KuUserDetailsService;

public class FingerPrintProvinder implements
        AuthenticationProvider {


    @Autowired
    private KuUserDetailsService kuUserDetailsService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        FingerAuthentication fingerAuthentication = (FingerAuthentication) authentication;

        UserDetails user = kuUserDetailsService.loadUserByFingerPrint(fingerAuthentication.getFingerPrint());

        fingerAuthentication.setPrincipal(user);
        return fingerAuthentication;
    }



    public boolean supports(Class<?> authentication) {
        return (FingerAuthentication.class
                .isAssignableFrom(authentication));
    }
}
