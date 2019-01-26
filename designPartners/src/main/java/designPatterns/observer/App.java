package designPatterns.observer;

import designPatterns.observer.impl.Channel;
import designPatterns.observer.impl.User;

/*
*
* Observer is used when
* - many object get information about change in one objects
*
*/
public class App {

    public static void main(String[] args) {
        Channel channel = new Channel();
        User user1 = new User("Kris");
        channel.publishNewVideo();
        User user2 = new User("Michael");

        channel.register(user1);
        channel.register(user2);
        channel.publishNewVideo();
    }
}
