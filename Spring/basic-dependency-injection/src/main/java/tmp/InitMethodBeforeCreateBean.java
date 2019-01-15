package tmp;

import org.springframework.beans.factory.InitializingBean;

public class InitMethodBeforeCreateBean implements InitializingBean {

    public void init() {
        System.out.println("init method, class InitMethodBeforeCreateBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet method, class InitMethodBeforeCreateBean");
    }
}
