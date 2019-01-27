package designPatterns.structural.decorator;

public class TextField implements Widget {

    private int width, height;

    public TextField(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("TextField: " + width + ", " + height);
    }
}
