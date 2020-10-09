package by.rymko.designpatterns.structural.s_06_flyweight;

import by.rymko.designpatterns.structural.s_06_flyweight.shape.Circle;
import by.rymko.designpatterns.structural.s_06_flyweight.shape.Point;
import by.rymko.designpatterns.structural.s_06_flyweight.shape.Shape;
import by.rymko.designpatterns.structural.s_06_flyweight.shape.Square;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactoryFlyweight {

    private static final Map<String, Shape> shapes = new HashMap<>();

    public Shape getShapeByTitle(String shapeTitle) {
        Shape shape = shapes.get(shapeTitle);
        if (shape == null) {
            switch (shapeTitle) {
                case "point":
                    shape = new Point();
                    break;
                case "circle":
                    shape = new Circle();
                    break;
                case "square":
                    shape = new Square();
                    break;
            }
            shapes.put(shapeTitle, shape);
        }
        return shape;
    }
}
