package tmp;

public class Repositorys {
    private DictionaryRepository dictionaryRepository;
    private UserRepository userRepository;

    public Repositorys() {
    }

    public Repositorys(DictionaryRepository dictionaryRepository, UserRepository userRepository) {
        this.dictionaryRepository = dictionaryRepository;
        this.userRepository = userRepository;
    }

    public DictionaryRepository getDictionaryRepository() {
        return dictionaryRepository;
    }

    public void setDictionaryRepository(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String toString() {
        return "Repositorys{" +
                "dictionaryRepository=" + dictionaryRepository +
                ", userRepository=" + userRepository +
                '}';
    }
}
