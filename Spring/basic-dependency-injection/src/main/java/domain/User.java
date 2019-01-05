package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class User {
    private String name;
    private Locale locale;
    private List<String> listString;
    private Set<Integer> setInteger;
    private Long[] arrayLong;

    public User(String name) {
        this.name = name;
    }

    public User(String name, Locale locale) {
        this.name = name;
        this.locale = locale;
    }

    public User(List<String> listString, Set<Integer> setInteger, Long[] arrayLong) {
        this.listString = listString;
        this.setInteger = setInteger;
        this.arrayLong = arrayLong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public List<String> getListString() {
        return listString;
    }

    public void setListString(List<String> listString) {
        this.listString = listString;
    }

    public Set<Integer> getSetInteger() {
        return setInteger;
    }

    public void setSetInteger(Set<Integer> setInteger) {
        this.setInteger = setInteger;
    }

    public Long[] getArrayLong() {
        return arrayLong;
    }

    public void setArrayLong(Long[] arrayLong) {
        this.arrayLong = arrayLong;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", locale=" + locale +
                ", listString=" + listString +
                ", setInteger=" + setInteger +
                ", arrayLong=" + Arrays.toString(arrayLong) +
                '}';
    }
}
