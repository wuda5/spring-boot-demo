package wu.test;

import com.git.hui.boot.autoconfig.AutoConfBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by @author yihui in 16:59 18/10/10.
 */
@Configuration
//@ComponentScan("com.git.hui.boot.autoconfig")
public class TestWuAutoConfig {

    @Bean
    public User autoWuUser() {
        System.out.println("注入自己的 user");
        return new User("auto mywu user load + " + System.currentTimeMillis());
    }

    @Bean
    public Car autoCar() {
        System.out.println("注入自己的 car");
        return new Car("auto mywu car load + " + System.currentTimeMillis());
    }


    @Data
    @AllArgsConstructor
    public class Car {

        private String name;


    }

}
