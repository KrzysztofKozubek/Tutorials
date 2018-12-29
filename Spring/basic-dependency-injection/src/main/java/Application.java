import api.Logger;
import api.UsersRepository;
import domain.User;
import impl.LoggerImpl;
import impl.UserRepositoryImpl;

public class Application {

    public static void main(String[] args) {
        Logger logger = new LoggerImpl();
        logger.setName("MyLogger");
        logger.setVersion(1.00);

        UsersRepository usersRepository = new UserRepositoryImpl();
        usersRepository.setLogger(logger);

        User user = usersRepository.createUser("Kris");
    }
}
