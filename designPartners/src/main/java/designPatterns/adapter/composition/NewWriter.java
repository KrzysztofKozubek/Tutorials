package designPatterns.adapter.composition;

public class NewWriter {
    public void save(String data, String color) {
        System.out.println("Save data: " + data + " color: " + color);
    }
}
