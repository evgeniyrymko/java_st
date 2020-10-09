package by.rymko.designpatterns.structural.s_06_flyweight.shape;

public class Circle implements Shape {

    private int radius = 5;

    @Override
    public void draw(int x, int y) {
        System.out.printf("Drawing circle with center coordinates %s, %s and radius %s.%n", x, y, radius);
    }
}
