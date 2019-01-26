package cBeanWithoutConstructor;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan("cBeanWithoutConstructor")
public class ConfBeanWithoutConstructor {

    @Bean("Connection1")
    public String connection1() {
        return "Connection 1";
    }

    @Bean("Connection2")
    public String connection2() {
        return "Connection 2";
    }

    @Bean("ConnectionManagerWithoutConstructor")
    public ConnectionManager connectionManager(
            @Qualifier("Connection1") String connection1,
            @Qualifier("Connection2") String connection2) {
        return ConnectionManager.getInstance(connection1, connection2);
    }

    @Bean("ConnectionManagerWithoutConstructorUsingList")
    public ConnectionManager connectionManager(List<String> connections) {
        return ConnectionManager.getInstance(connections);
    }
}
