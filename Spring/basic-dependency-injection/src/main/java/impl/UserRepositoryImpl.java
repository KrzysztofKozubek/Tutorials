package impl;

import api.Logger;
import api.UsersRepository;
import domain.User;

public class UserRepositoryImpl implements UsersRepository {
    private Logger logger;

    public User createUser(String name) {
        logger.log("User has been created: " + name);
        return new User(name);
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
