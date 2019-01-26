package designPatterns.adapter;

import designPatterns.adapter.composition.AdapterComposition;
import designPatterns.adapter.inheritance.*;

public class App {
    public static void main(String[] args) {
        Writer writer = new AdapterInherit();
        writer.save("Important data");

        designPatterns.adapter.composition.Writer writer1 = new AdapterComposition();
        writer1.save("Super important data");
    }
}
