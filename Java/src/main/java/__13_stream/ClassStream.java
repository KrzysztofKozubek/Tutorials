package __13_stream;


/*
 * Functional interface has only one abstract method
 * This interfaces r annotation @FunctionalInterface.
 *
 *
 * Lambda is sth like method in basic but this method u can storage in variable
 * Lambda contains args arrow token and body of lambda expression
 *
 *
 * Stream
 * Classes to support functional-style operations on streams of elements,
 * such as map-reduce transformations on collections.
 * */

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class ClassStream {

    private List<BoardGame> games = new ArrayList<>(Arrays.asList(
            new BoardGame("Terraforming Mars", 8.38, new BigDecimal("123.49"), 1, 5),
            new BoardGame("Codenames", 7.82, new BigDecimal("64.95"), 2, 8),
            new BoardGame("Puerto Rico", 8.07, new BigDecimal("149.99"), 2, 5),
            new BoardGame("Terra Mystica", 8.26, new BigDecimal("252.99"), 2, 5),
            new BoardGame("Scythe", 8.3, new BigDecimal("314.95"), 1, 5),
            new BoardGame("Power Grid", 7.92, new BigDecimal("145"), 2, 6),
            new BoardGame("7 Wonders Duel", 8.15, new BigDecimal("109.95"), 2, 2),
            new BoardGame("Dominion: Intrigue", 7.77, new BigDecimal("159.95"), 2, 4),
            new BoardGame("Patchwork", 7.77, new BigDecimal("75"), 2, 2),
            new BoardGame("The Castles of Burgundy", 8.12, new BigDecimal("129.95"), 2, 4)
    ));

    private void exampleUsingStream() {
        /*
         * Now we want to find game where:
         * can play at least 4 person
         * rating greater then 8
         * price less then 150
         * */

        Set<BoardGame> lookingForGames = games.stream()
                .filter(game -> game.maxPlayers >= 4)
                .filter(game -> game.rating >= 8)
                .filter(game -> game.price.compareTo(BigDecimal.valueOf(150L)) < 0)
                .collect(Collectors.toSet());
        lookingForGames.isEmpty();
    }

    private void exampleNotUsingStream() {
        Set<BoardGame> lookingForGames = new HashSet<>();
        for (BoardGame game : games) {
            if (game.maxPlayers >= 4 && game.rating >= 8 && game.price.compareTo(BigDecimal.valueOf(150L)) < 0) {
                lookingForGames.add(game);
            }
        }
        lookingForGames.isEmpty();
    }

    private void generateListBoardGames(int size) {
        games.clear();
        for (int i = 0; i < size; i++) {
            String name = String.valueOf(i);
            double rating = new Random().nextDouble() * 10;
            BigDecimal price = new BigDecimal((new Random().nextDouble() * 200));
            int minPlayers = new Random().nextInt();
            int maxPlayers = minPlayers + 3;
            games.add(new BoardGame(name, rating, price, minPlayers, maxPlayers));
        }
    }

    private void compareTimeStreamAndWithoutStream() {
        long start = System.nanoTime();
        exampleUsingStream();
        long elapsedTime = System.nanoTime() - start;
        System.out.println(String.format("%s: %sns -> %sms -> %ss",
                "Stream",
                elapsedTime,
                elapsedTime / 1_000_000,
                elapsedTime / 1_000_000_000));

        start = System.nanoTime();
        exampleNotUsingStream();
        elapsedTime = System.nanoTime() - start;
        System.out.println(String.format("%s: %sns -> %sms -> %ss",
                "Without Stream",
                elapsedTime,
                elapsedTime / 1_000_000,
                elapsedTime / 1_000_000_000));
    }

    /* Mainly stream r slowest */
    private void compareTimeForBiggestList() {
        System.out.println("\ncompare time for 10 objects");
        generateListBoardGames(10);
        compareTimeStreamAndWithoutStream();
        System.out.println("\ncompare time for 100 objects");
        generateListBoardGames(100);
        compareTimeStreamAndWithoutStream();
        System.out.println("\ncompare time for 1.000 objects");
        generateListBoardGames(100);
        compareTimeStreamAndWithoutStream();
        System.out.println("\ncompare time for 10.000 objects");
        generateListBoardGames(1000);
        compareTimeStreamAndWithoutStream();
        System.out.println("\ncompare time for 100.000 objects");
        generateListBoardGames(10000);
        compareTimeStreamAndWithoutStream();
        System.out.println("\ncompare time for 1.000.000 objects");
        generateListBoardGames(100000);
        compareTimeStreamAndWithoutStream();
        System.out.println("\ncompare time for 10.000.000 objects");
        generateListBoardGames(1000000);
        compareTimeStreamAndWithoutStream();
    }

    public static void main(String[] args) {
        new ClassStream().compareTimeForBiggestList();
    }
}
