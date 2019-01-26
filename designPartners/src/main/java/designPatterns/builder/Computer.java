package designPatterns.builder;

public class Computer {

//    required parameters
    private String HDD;
    private String RAM;
    private String motherboard;

//    optional parameters
    private String graphicCard;

    private Computer(String HDD, String RAM, String motherboard, String graphicCard) {
        this.HDD = HDD;
        this.RAM = RAM;
        this.motherboard = motherboard;
        this.graphicCard = graphicCard;
    }

    public String getHDD() {
        return HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public String getGraphicCard() {
        return graphicCard;
    }

    public static class ComputerBuilder {

//    required parameters
        private String HDD;
        private String RAM;
        private String motherboard;

//    optional parameters
        private String graphicCard;

        public static ComputerBuilder builder() {
            return new ComputerBuilder();
        }

        public ComputerBuilder HDD(String HDD) {
            this.HDD = HDD;
            return this;
        }

        public ComputerBuilder RAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public ComputerBuilder motherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        public ComputerBuilder graphicCard(String graphicCard) {
            this.graphicCard = graphicCard;
            return this;
        }

        private void notNull(Object object) throws IllegalArgumentException {
            if (object == null) {
                throw new IllegalArgumentException();
            }
        }

        private void checkCorrectArguments() throws IllegalArgumentException {
            notNull(HDD);
            notNull(RAM);
            notNull(motherboard);
        }

        public Computer build() throws IllegalArgumentException {
            checkCorrectArguments();
            return new Computer(HDD, RAM, motherboard, graphicCard);
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "HDD='" + HDD + '\'' +
                ", RAM='" + RAM + '\'' +
                ", motherboard='" + motherboard + '\'' +
                ", graphicCard='" + graphicCard + '\'' +
                '}';
    }
}
