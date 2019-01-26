package cBeanWithoutConstructor;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cBeanWithoutConstructor")
public class ConfBeanWithoutConstructor {

    @Bean("connection1")
    @Qualifier("connection1")
    public String connection1() {
        return "Connection 1";
    }

    @Bean("connection2")
    @Qualifier("connection2")
    public String connection2() {
        return "Connection 2";
    }

    @Bean("ConnectionManagerWithoutConstructor")
    public ConnectionManager connectionManager(
            @Qualifier("connection1") String connection1,
            @Qualifier("connection2") String connection2) {
        return ConnectionManager.getInstance(connection1, connection2);
    }
}
