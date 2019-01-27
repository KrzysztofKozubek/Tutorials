package designPatterns.structural.proxy.impl;

import designPatterns.structural.proxy.interfaces.Image;

public class RealImage implements Image {

    private String fileName;

    RealImage(String fileName) {
        this.fileName = fileName;
        loadImage(fileName);
    }

    private void loadImage(String fileName) {
        System.out.println("Load file: " + fileName);
    }

    @Override
    public void display() {
        System.out.println(fileName);
    }
}
