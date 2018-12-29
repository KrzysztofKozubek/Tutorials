package impl;

import api.Logger;
import api.UsersRepository;
import domain.User;

public class UserRepositoryImpl implements UsersRepository {
    private Logger logger;

    public UserRepositoryImpl(Logger logger, String message, String user) {
        this.logger = logger;
        logger.logInfo("User: " + user + ": \"" + message + "\"");
    }

    public User createUser(String name) {
        logger.logInfo("User has been created: " + name);
        return new User(name);
    }
}
