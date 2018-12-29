import api.UsersRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationSpring {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        UsersRepository userRepository = context.getBean("userRepository", UsersRepository.class);
        userRepository.createUser("Kris");
    }
}
