package impl;

import domain.User;

public class SomeBean {
    private String string;
    private Integer integer;
    private User user;

    public SomeBean() {
    }

    public SomeBean(Integer number, String string) {
        System.out.println(number + " " + string);
    }

    public SomeBean(String string, Integer integer, User user) {
        this.string = string;
        this.integer = integer;
        this.user = user;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "SomeBean{" +
                "string='" + string + '\'' +
                ", integer=" + integer +
                ", user=" + user +
                '}';
    }
}
