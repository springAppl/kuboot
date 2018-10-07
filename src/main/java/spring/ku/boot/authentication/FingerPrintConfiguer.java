package spring.ku.boot.authentication;

import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import spring.ku.boot.filter.FingerPrintFilter;

public final class FingerPrintConfiguer <H extends HttpSecurityBuilder<H>> extends
        AbstractAuthenticationFilterConfigurer<H, FingerPrintConfiguer<H>, FingerPrintFilter> {

    public FingerPrintConfiguer() {
        super(new FingerPrintFilter(), null);
    }


    @Override
    protected RequestMatcher createLoginProcessingUrlMatcher(String loginProcessingUrl) {
        return new AntPathRequestMatcher(loginProcessingUrl, "POST");
    }

    @Override
    public void init(H http) throws Exception {
        super.init(http);
        http.addFilterAfter(super.getAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
