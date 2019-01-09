package tmp;

public class UserRepository {

    boolean userExists = true;

    public boolean exists(String userName) {
        return userExists;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "userExists=" + userExists +
                '}';
    }
}
