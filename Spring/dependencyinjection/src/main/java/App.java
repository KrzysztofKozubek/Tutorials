import aFirstBean.ConfigFirstBean;
import aFirstBean.FirstBean;
import bParameterizedConstructor.ConfParameterizedConstructor;
import bParameterizedConstructor.MessageHandler;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                ConfigFirstBean.class, FirstBean.class,
                ConfParameterizedConstructor.class, MessageHandler.class
        );
        createFirstBean(context);
        createBeanWithParameterizedConstructor(context);
    }

    private static void createFirstBean(AnnotationConfigApplicationContext context) {
        FirstBean firstBean = context.getBean("FirstBean", FirstBean.class);
        System.out.println(firstBean);
        firstBean = context.getBean("ServiceFirstBean", FirstBean.class);
        System.out.println(firstBean);
    }

    private static void createBeanWithParameterizedConstructor(AnnotationConfigApplicationContext context) {
        System.out.println();
        MessageHandler messageHandler = context.getBean("MessageHandlerParameterizedConstructor", MessageHandler.class);
        messageHandler.logMessage("Create message info");
        System.out.println();
    }
}
