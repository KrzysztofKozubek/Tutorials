package domain;

public class Person {
    private String name;
    private Integer age;

    private Person() {}

    public static Person getInstance(String name, Integer age) {
        Person person = new Person();
        person.age = age;
        person.name = name;
        return person;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
