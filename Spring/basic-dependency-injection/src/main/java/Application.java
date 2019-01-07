import api.Logger;
import api.UsersRepository;
import domain.Account;
import domain.Person;
import domain.User;
import impl.AccountCreator;
import impl.LoggerImpl;
import impl.SomeBean;
import impl.UserRepositoryImpl;
import tmp.InjectedBean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {
        Logger logger = new LoggerImpl();
        logger.setName("MyLogger");
        logger.setVersion(1.00);
        UsersRepository usersRepository = new UserRepositoryImpl(logger, "Logger has been created", "Kris");
        User user = usersRepository.createUser("Kris");

        SomeBean someBean = new SomeBean(7, "string");

        factoryMethod();
        log4j();
        innerBean();
        collectionBean();
        autowired();
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

        User user = new User("Kris", locale);
        SomeBean someBean = new SomeBean("Kris", 25, user);
        System.out.println(someBean);
        user = new User("Kris", locale);
        someBean = new SomeBean("Kris", 25, user);
        System.out.println(someBean);
    }

    private static void log4j() {
        String someString = new String("someString");
        System.out.println(someString);
    }

    private static void innerBean() {
        User user = new User(null);
        user.setLocale(Locale.getDefault());
        System.out.println(user);
    }

    private static void collectionBean() {
        List<String> listString = Stream.of("One", "Two", "Three").collect(Collectors.toList());
        Set<Integer> setInteger = Stream.of(1, 2, 3).collect(Collectors.toSet());
        Long[] arrayLong = new Long[]{1L, 2L, 3L};
        User user = new User(listString, setInteger, arrayLong);
        System.out.println(user);

        user = new User("Kris");
        Map<String, Locale> localeMap = new HashMap<>();
        Properties settings = new Properties();
        localeMap.put("DEFAULT", Locale.getDefault());
        localeMap.put("GERMANY", Locale.GERMANY);
        user.setLocaleMap(localeMap);
        settings.put("key1", "value1");
        settings.put("key2", "value2");
        settings.put("key3", "value3");
        user.setSettings(settings);
        System.out.println(user);
    }

    private static void autowired() {
        tmp.SomeBean someBean = new tmp.SomeBean();
        someBean.setInjectedBean1(new InjectedBean("Bean 1"));
        someBean.setInjectedBean2(someBean.getInjectedBean1());
        System.out.println(someBean);
    }
}
