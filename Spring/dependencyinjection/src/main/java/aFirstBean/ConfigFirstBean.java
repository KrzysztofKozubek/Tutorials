package aFirstBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigFirstBean {
    @Bean("FirstBean")
    public FirstBean firstBean() {
        FirstBean firstBean = new FirstBean();
        firstBean.setName("First Bean");
        return firstBean;
    }
}
