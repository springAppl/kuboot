package spring.ku.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import spring.ku.boot.security.KuUserDetailsService;
import spring.ku.boot.service.UserReadService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .userDetailsService(userDetailsService())
                .antMatcher("/api/**")
                .authorizeRequests()
                .antMatchers("/api/admin/**").hasRole("ADMIN")
                .antMatchers("/api/article").authenticated()
                .mvcMatchers(HttpMethod.PUT, "/api/index").authenticated()
                .mvcMatchers(HttpMethod.GET, "/api/user").authenticated()
                .mvcMatchers(HttpMethod.PUT, "/api/index").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.PUT, "/api/index/use/default").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.PUT, "/api/shop-detail").authenticated()
                .mvcMatchers(HttpMethod.PUT, "/api/shop-detail/{id}").authenticated()
                .mvcMatchers(HttpMethod.POST, "/api/user/login").permitAll()
                .mvcMatchers(HttpMethod.PUT, "/api/user/logout").authenticated()
                .and()
                .formLogin()
                .disable()
                .logout()
                .disable()
                .cors()
                .disable()
                .csrf()
                .disable();
    }


    @Bean
    public UserDetailsService userDetailsService(UserReadService userReadService){
        return new KuUserDetailsService(userReadService);
    }


}
