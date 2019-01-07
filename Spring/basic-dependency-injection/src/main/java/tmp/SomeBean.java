package tmp;

public class SomeBean {

    private InjectedBean injectedBean1;
    private InjectedBean injectedBean2;

    public SomeBean() {
    }

    public SomeBean(InjectedBean injectedBean1, InjectedBean injectedBean2) {
        this.injectedBean1 = injectedBean1;
        this.injectedBean2 = injectedBean2;
    }

    public InjectedBean getInjectedBean1() {
        return injectedBean1;
    }

    public void setInjectedBean1(InjectedBean injectedBean1) {
        this.injectedBean1 = injectedBean1;
    }

    public InjectedBean getInjectedBean2() {
        return injectedBean2;
    }

    public void setInjectedBean2(InjectedBean injectedBean2) {
        this.injectedBean2 = injectedBean2;
    }

    @Override
    public String toString() {
        return "SomeBean{" +
                "injectedBean1=" + injectedBean1 +
                ", injectedBean2=" + injectedBean2 +
                '}';
    }
}
