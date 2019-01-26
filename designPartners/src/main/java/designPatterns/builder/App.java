package designPatterns.builder;
import designPartners.builder.Computer;
import designPatterns.builder.classic.builder.RaceCarBuilder;
import designPatterns.builder.classic.logic.CarDirector;

import static designPartners.builder.Computer.ComputerBuilder;

public class App {

    public static void main(String[] args) {

//        fluent builder
        Computer computer = ComputerBuilder.builder()
                .HDD("HDD")
                .RAM("RAM")
                .motherboard("motherboard")
                .graphicCard("graphicCard")
                .build();

        System.out.println(computer);

//        classic builder
        RaceCarBuilder raceCarBuilder = new RaceCarBuilder();
        CarDirector carDirector = new CarDirector(raceCarBuilder);
        carDirector.makeCar();
        System.out.println(carDirector.getCar());
    }
}
