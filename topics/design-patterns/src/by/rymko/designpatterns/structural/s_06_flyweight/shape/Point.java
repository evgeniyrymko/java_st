package by.rymko.designpatterns.structural.s_06_flyweight.shape;

public class Point implements Shape {

    @Override
    public void draw(int x, int y) {
        System.out.format("Drawing point with coordinates %s, %s.%n", x, y);
    }
}
