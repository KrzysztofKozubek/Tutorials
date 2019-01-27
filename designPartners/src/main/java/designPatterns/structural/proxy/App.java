package designPatterns.structural.proxy;

import designPatterns.structural.proxy.impl.ProxyImage;
import designPatterns.structural.proxy.interfaces.Image;

/*
* Proxy is used when
* create object on call (creating is expensive)
* control access to objects
* has information about real objects
* we need do sth during access to objects
* */
public class App {
    public static void main(String[] args) {
        Image image = new ProxyImage("test.jpg");
        image.display();
        image.display();
    }
}
