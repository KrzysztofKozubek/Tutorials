package designPatterns.creational.builder;
import designPatterns.creational.builder.classic.builder.RaceCarBuilder;
import designPatterns.creational.builder.classic.logic.CarDirector;

/*
* Builder is used when
* process creating object is complicated
* process creating object has many logic
* */
public class App {

    public static void main(String[] args) {

//        fluent builder
        Computer computer = Computer.ComputerBuilder.builder()
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
