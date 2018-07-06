package spring.ku.boot.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MVCConfig extends WebMvcConfigurerAdapter {
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }


    class BIncrement {
        ThreadLocal<Integer> num = ThreadLocal.withInitial(() -> 0);
        public int increase() {
            num.set(num.get() + 1);
            return num.get();
        }
        public void print() {
            for (int i = 0; i < 4; i++) {
                System.out.println(Thread.currentThread().getName() + " " + increase());
            }
        }
    }
}
