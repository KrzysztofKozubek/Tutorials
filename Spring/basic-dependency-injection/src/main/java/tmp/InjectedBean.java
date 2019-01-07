package tmp;

public class InjectedBean {
    private String name;

    public InjectedBean(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "InjectedBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
