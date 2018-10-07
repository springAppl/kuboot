package spring.ku.boot.filter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import spring.ku.boot.authentication.FingerAuthentication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FingerPrintFilter extends AbstractAuthenticationProcessingFilter {

    public FingerPrintFilter() {
        super(new AntPathRequestMatcher("/api/finger-print", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        String fingerPrint = getFingerPrint(request);
        FingerAuthentication authentication = new FingerAuthentication(fingerPrint);
        Authentication auth =  this.getAuthenticationManager().authenticate(authentication);
        return auth;
    }

    private String getFingerPrint(HttpServletRequest request) {
        return request.getParameter("fingerPrint");
    }
}
