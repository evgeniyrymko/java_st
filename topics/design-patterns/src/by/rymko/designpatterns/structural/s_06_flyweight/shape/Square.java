package by.rymko.designpatterns.structural.s_06_flyweight.shape;

public class Square implements Shape {

    private int side = 10;

    @Override
    public void draw(int x, int y) {
        System.out.printf("Drawing square with center coordinates %s, %s and side %s.%n", x, y, side);
    }
}
