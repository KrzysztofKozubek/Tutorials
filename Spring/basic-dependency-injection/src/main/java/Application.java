import api.Logger;
import api.UsersRepository;
import domain.Account;
import domain.Person;
import domain.User;
import impl.AccountCreator;
import impl.LoggerImpl;
import impl.SomeBean;
import impl.UserRepositoryImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Application {

    public static void main(String[] args) {
        Logger logger = new LoggerImpl();
        logger.setName("MyLogger");
        logger.setVersion(1.00);
        UsersRepository usersRepository = new UserRepositoryImpl(logger, "Logger has been created", "Kris");
        User user = usersRepository.createUser("Kris");

        SomeBean someBean = new SomeBean(7, "string");

        factoryMethod();
    }

    private static void factoryMethod() {
        Locale locale = Locale.getDefault();
        Calendar calendar = GregorianCalendar.getInstance(locale);
        DateFormat format = SimpleDateFormat.getInstance();
        System.out.println(format.format(calendar.getTime()));

        Person person = Person.getInstance("Kris", 25);
        System.out.println(person);

        AccountCreator accountCreator = new AccountCreator();
        Account account = accountCreator.createAccount("Kris");
        System.out.println(account);
    }
}
