package importantInterface;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

public class Bean implements BeanNameAware, ApplicationContextAware {
    private String name;
    private ApplicationContext applicationContext;

//    Override method interface BeanNameAware
//    Method is call after create bean
//    Argument this method is name of bean
    @Override
    public void setBeanName(String s) {
        this.name = s;
    }

//    Override method interface ApplicationContextAware
//    Method is call after create bean
//    Argument this method contains info about beans
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public String toString() {
        Map<String, Bean> beansOfType = applicationContext.getBeansOfType(Bean.class);
        return "Bean{\n" +
                "name='" + name + "'\n" +
                "applicationContext='" + beansOfType.size() + '\'' +
                '}';
    }

    /*
    more examples u can find here:
    https://docs.spring.io/spring/docs/5.1.4.RELEASE/spring-framework-reference/core.html#beans-factory-method-injection
    */
}
