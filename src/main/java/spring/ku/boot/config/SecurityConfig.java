package spring.ku.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 权限管理, EntryPoint, 使用状态码。
        http
                .authorizeRequests()
                .antMatchers("/api/admin/**").hasRole("ADMIN")
                .antMatchers("/api/article").authenticated()
                .mvcMatchers(HttpMethod.PUT, "/api/index").authenticated()
                .mvcMatchers(HttpMethod.GET, "/api/user").authenticated()
                .mvcMatchers(HttpMethod.PUT, "/api/index").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.PUT, "/api/index/use/default").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.PUT, "/api/shop-detail").authenticated()
                .mvcMatchers(HttpMethod.PUT, "/api/shop-detail/{id}").authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/api/login")
                .usernameParameter("account")
                .and()
                .logout()
                .logoutUrl("/api/logout")
                .logoutSuccessUrl("/")
                .and()
                .cors()
                .disable()
                .csrf()
                .disable();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        return new KuUserDetailsService();
//    }
}
