package __13_stream;

import java.math.BigDecimal;

class BoardGame {
    final String name;
    final double rating;
    final BigDecimal price;
    final int minPlayers;
    final int maxPlayers;

    BoardGame(String name, double rating, BigDecimal price, int minPlayers, int maxPlayers) {
        this.name = name;
        this.rating = rating;
        this.price = price;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
    }

    @Override
    public String toString() {
        return "BoardGame{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                ", minPlayers=" + minPlayers +
                ", maxPlayers=" + maxPlayers +
                '}';
    }
}