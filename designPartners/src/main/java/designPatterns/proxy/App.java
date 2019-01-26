package designPatterns.proxy;

import designPatterns.proxy.impl.ProxyImage;
import designPatterns.proxy.interfaces.Image;

public class App {
    public static void main(String[] args) {
        Image image = new ProxyImage("test.jpg");
        image.display();
        image.display();
    }
}
