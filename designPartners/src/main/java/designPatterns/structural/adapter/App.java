package designPatterns.structural.adapter;

import designPatterns.structural.adapter.composition.AdapterComposition;
import designPatterns.structural.adapter.composition.Writer;
import designPatterns.structural.adapter.inheritance.AdapterInherit;

/*
* Adapter is using when
* cannot use class bc interface is incompatible
* cannot change source class
* */
public class App {
    public static void main(String[] args) {
        designPatterns.structural.adapter.inheritance.Writer writer = new AdapterInherit();
        writer.save("Important data");

        Writer writer1 = new AdapterComposition();
        writer1.save("Super important data");
    }
}
