package by.rymko.designpatterns.structural.s_06_flyweight;

import by.rymko.designpatterns.structural.s_06_flyweight.shape.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        ShapeFactoryFlyweight shapeFactoryFlyweight = new ShapeFactoryFlyweight();

        List<Shape> shapes = new ArrayList<>();

        shapes.add(shapeFactoryFlyweight.getShapeByTitle("point"));
        shapes.add(shapeFactoryFlyweight.getShapeByTitle("point"));
        shapes.add(shapeFactoryFlyweight.getShapeByTitle("circle"));
        shapes.add(shapeFactoryFlyweight.getShapeByTitle("circle"));
        shapes.add(shapeFactoryFlyweight.getShapeByTitle("square"));
        shapes.add(shapeFactoryFlyweight.getShapeByTitle("square"));

        Random random = new Random();
        for (Shape shape : shapes) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            shape.draw(x, y);
            System.out.println(shape.toString());
            System.out.println("-----");
        }

    }
}
