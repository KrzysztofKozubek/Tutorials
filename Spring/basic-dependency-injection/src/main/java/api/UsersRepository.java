package api;

import domain.User;

public interface UsersRepository {
    User createUser(String name);

    void setLogger(Logger logger);
}
