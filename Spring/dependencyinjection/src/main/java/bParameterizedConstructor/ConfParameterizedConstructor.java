package bParameterizedConstructor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("bParameterizedConstructor")
public class ConfParameterizedConstructor {

    @Bean
    public Logger getLogger() {
        return Logger.getRootLogger();
    }

    @Bean
    @Qualifier("nameLogger")
    public String getDefaultMessage() {
        return "Root logger";
    }
}
