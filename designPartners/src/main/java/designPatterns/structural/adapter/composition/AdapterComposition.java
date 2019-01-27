package designPatterns.structural.adapter.composition;

public class AdapterComposition implements Writer {

    private NewWriter writer;

    public AdapterComposition() {
        writer = new NewWriter();
    }

    @Override
    public void save(String data) {
        writer.save(data, "black-white");
    }
}
