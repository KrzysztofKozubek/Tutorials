package designPatterns.observer.impl;

import designPatterns.observer.interfaces.Observer;

public class User implements Observer {

    private String name;
    private int videosToWatch;

    public User(String name) {
        this.name = name;
        this.videosToWatch = 0;
    }

    @Override
    public void update() {
        videosToWatch++;
        System.out.println("Hey! " + name + "! There is a new video!" + "You hve " + videosToWatch + " videos to watch.");
    }
}
