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

        UsersRepository usersRepository = new UserRepositoryImpl(logger, "Logger has been created", "Kris");

        User user = usersRepository.createUser("Kris");
    }
}
