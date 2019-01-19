package tmp;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class InitMethodBeforeCreateBean implements InitializingBean, DisposableBean {

    public void init() {
        System.out.println("init method, class InitMethodBeforeCreateBean");
    }

    public void destroyMethod() {
        System.out.println("destroyMethod method, class InitMethodBeforeCreateBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet method, class InitMethodBeforeCreateBean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy method, class InitMethodBeforeCreateBean");
    }
}
