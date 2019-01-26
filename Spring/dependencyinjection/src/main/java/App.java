import aFirstBean.ConfigFirstBean;
import aFirstBean.FirstBean;
import bParameterizedConstructor.ConfParameterizedConstructor;
import bParameterizedConstructor.MessageHandler;
import cBeanWithoutConstructor.ConfBeanWithoutConstructor;
import cBeanWithoutConstructor.ConnectionManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                ConfigFirstBean.class, FirstBean.class,
                ConfParameterizedConstructor.class, MessageHandler.class,
                ConfBeanWithoutConstructor.class, ConnectionManager.class
        );
        createFirstBean(context);
        createBeanWithParameterizedConstructor(context);
        createBeanWithoutConstructor(context);
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

    private static void createBeanWithoutConstructor(AnnotationConfigApplicationContext context) {
        System.out.println();
        ConnectionManager connectionManager = context.getBean("ConnectionManagerWithoutConstructor", ConnectionManager.class);
        System.out.println(connectionManager.getConnections());
        System.out.println();
    }
}
