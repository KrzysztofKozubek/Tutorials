import api.UsersRepository;
import domain.Account;
import domain.User;
import impl.SomeBean;
import domain.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    }

    private static void factoryMethod(ApplicationContext context) {
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
    }

    private static void log4j(ApplicationContext context) {
        String someString = context.getBean("someString", String.class);
        System.out.println(someString);
    }

    private static void innerBean(ApplicationContext context) {
        User user = context.getBean("userWithInnerBean", User.class);
        System.out.println(user);
    }

    private static void collectionBean(ApplicationContext context) {
        User user = context.getBean("collectionSomeBean", User.class);
        System.out.println(user);
    }
}
