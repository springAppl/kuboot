package spring.ku.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import spring.ku.boot.authentication.FingerPrintConfiguer;
import spring.ku.boot.authentication.FingerPrintProvinder;
import spring.ku.boot.security.KuUserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 权限管理, EntryPoint, 使用状态码。

        http
                .userDetailsService(userDetailsService())
                .authenticationProvider(fingerPrintProvinder())
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
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .loginProcessingUrl("/api/login")
                .usernameParameter("account")
                .successForwardUrl("/boot")
                .and()
                .logout()
                .logoutUrl("/api/logout")
                .logoutSuccessUrl("/login")
                .and()
                .apply(new FingerPrintConfiguer<>())
                .loginProcessingUrl("/api/finger-print")
                .defaultSuccessUrl("/boot")
                .and()
                .cors()
                .disable()
                .csrf()
                .disable();
    }


    @Bean
    public UserDetailsService userDetailsService(){
        return new KuUserDetailsService();
    }

    @Bean
    public FingerPrintProvinder fingerPrintProvinder(){
        return new FingerPrintProvinder();
    }

}
