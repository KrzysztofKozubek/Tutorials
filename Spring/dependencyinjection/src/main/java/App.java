import aFirstBean.ConfigFirstBean;
import aFirstBean.FirstBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                ConfigFirstBean.class, FirstBean.class
        );
        createFirstBean(context);
    }

    private static void createFirstBean(AnnotationConfigApplicationContext context) {
        FirstBean firstBean = context.getBean("FirstBean", FirstBean.class);
        System.out.println(firstBean);
        firstBean = context.getBean("ServiceFirstBean", FirstBean.class);
        System.out.println(firstBean);
    }
}
