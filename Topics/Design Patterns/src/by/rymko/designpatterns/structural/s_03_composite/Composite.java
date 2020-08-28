package by.rymko.designpatterns.structural.s_03_composite;

import by.rymko.designpatterns.structural.s_03_composite.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Shape {

    private List<Shape> components = new ArrayList<>();

    public void addComponent(Shape shape) {
        components.add(shape);
    }

    public void removeComponent(Shape shape) {
        components.remove(shape);
    }

    @Override
    public void draw() {
        for (Shape component : components) {
            component.draw();
        }
    }
}
