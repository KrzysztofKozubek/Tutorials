package domain;

import java.util.Locale;

public class User {
    private String name;
    private Locale locale;

    public User(String name) {
        this.name = name;
    }

    public User(String name, Locale locale) {
        this.name = name;
        this.locale = locale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", locale=" + locale +
                '}';
    }
}
