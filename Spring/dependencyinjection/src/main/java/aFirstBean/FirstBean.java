package aFirstBean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ServiceFirstBean")
public class FirstBean {

    @Qualifier("Default value @Qualifier")
    private String name = new String("Default value name ServiceFirstBean");

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FirstBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
