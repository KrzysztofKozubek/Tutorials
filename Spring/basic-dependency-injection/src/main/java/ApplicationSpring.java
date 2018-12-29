import api.UsersRepository;
import domain.Account;
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
    }

    private static void factoryMethod(ApplicationContext context) {
        DateFormat format = context.getBean("formatter", DateFormat.class);
        Calendar calendar = context.getBean("calendar", Calendar.class);
        System.out.println(format.format(calendar.getTime()));

        Person person = context.getBean("person", Person.class);
        System.out.println(person);

        Account account = context.getBean("someAccount", Account.class);
        System.out.println(account);
    }
}
