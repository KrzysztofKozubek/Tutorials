import api.UsersRepository;
import domain.Account;
import domain.User;
import impl.SomeBean;
import domain.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import scope.Bean1;
import scope.Bean2;
import sun.awt.AppContext;

import java.text.DateFormat;
import java.util.Calendar;

public class ApplicationSpring {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        UsersRepository userRepository = context.getBean("userRepository", UsersRepository.class);
        userRepository.createUser("Kris");

        SomeBean someBean = context.getBean("someBean", SomeBean.class);

        factoryMethod(context);
        log4j(context);
        innerBean(context);
        collectionBean(context);
        autowired(context);
        initBeforeBeanHasBeenCreated(context);
        scopeBean(context);
    }

    private static void factoryMethod(ApplicationContext context) {
        System.out.println("Factory Method - call static method");
        DateFormat format = context.getBean("formatter", DateFormat.class);
        Calendar calendar = context.getBean("calendar", Calendar.class);
        System.out.println(format.format(calendar.getTime()));

        Person person = context.getBean("person", Person.class);
        System.out.println(person);

        Account account = context.getBean("someAccount", Account.class);
        System.out.println(account);

        SomeBean someBean = context.getBean("someBeanPIC", SomeBean.class);
        System.out.println(someBean);
        someBean = context.getBean("someBeanPIC2", SomeBean.class);
        System.out.println(someBean);
        System.out.println();
    }

    private static void log4j(ApplicationContext context) {
        System.out.println("log4j - lib to display logs");
        String someString = context.getBean("someString", String.class);
        System.out.println(someString);
        System.out.println();
    }

    private static void innerBean(ApplicationContext context) {
        System.out.println("Inner Bean - create bean through constructor and properties");
        User user = context.getBean("userWithInnerBean", User.class);
        System.out.println(user);
        System.out.println();
    }

    private static void collectionBean(ApplicationContext context) {
        System.out.println("Collection - inject collections (array, list, set, map, properties)");
        User user = context.getBean("collectionSomeBean", User.class);
        System.out.println(user);

        user = context.getBean("mapSomeBean", User.class);
        System.out.println(user);
        System.out.println();
    }

    private static void autowired(ApplicationContext context) {
        System.out.println("Autowired - by_name, by_type, by_constructor");
        tmp.SomeBean someBean = context.getBean("someInjectedBean", tmp.SomeBean.class);
        System.out.println(someBean);

        tmp.Repositorys repositorys = context.getBean("repositoryBean", tmp.Repositorys.class);
        System.out.println(repositorys);
        System.out.println();
    }

    private static void initBeforeBeanHasBeenCreated(ApplicationContext context) {
        System.out.println("Init method - init method before bean has been created");
        tmp.InitMethodBeforeCreateBean initMethodBeforeCreateBean = context.getBean("initMethodBeforeCreateBean", tmp.InitMethodBeforeCreateBean.class);
        System.out.println(initMethodBeforeCreateBean);
        initMethodBeforeCreateBean = context.getBean("initMethodUsingInterface", tmp.InitMethodBeforeCreateBean.class);
        System.out.println(initMethodBeforeCreateBean);
        System.out.println();
    }

    private static void scopeBean(ApplicationContext context) {
        System.out.println("Scope bean - create bean with prototype scope");
        Bean1 bean1Scope = context.getBean("bean1Scope", Bean1.class);
        Bean2 bean2Scope = context.getBean("bean2Scope", Bean2.class);
        System.out.println(bean1Scope.getCounter());
        System.out.println(bean2Scope.getCounter());
        System.out.println();
    }
}
