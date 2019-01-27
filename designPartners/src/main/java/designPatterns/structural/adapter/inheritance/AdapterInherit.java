package designPatterns.structural.adapter.inheritance;

public class AdapterInherit extends NewWriter implements Writer {

    @Override
    public void save(String data) {
        save(data, "black-white");
    }
}
