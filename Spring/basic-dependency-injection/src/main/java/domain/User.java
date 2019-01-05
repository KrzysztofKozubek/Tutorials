package domain;

import java.util.*;

public class User {
    private String name;
    private Locale locale;
    private List<String> listString;
    private Set<Integer> setInteger;
    private Long[] arrayLong;
    private Map<String, Locale> localeMap;
    private Properties settings;

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

    public Map<String, Locale> getLocaleMap() {
        return localeMap;
    }

    public void setLocaleMap(Map<String, Locale> localeMap) {
        this.localeMap = localeMap;
    }

    public Properties getSettings() {
        return settings;
    }

    public void setSettings(Properties settings) {
        this.settings = settings;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", locale=" + locale +
                ", listString=" + listString +
                ", setInteger=" + setInteger +
                ", arrayLong=" + Arrays.toString(arrayLong) +
                ", localeMap=" + localeMap +
                ", settings=" + settings +
                '}';
    }
}
