package design_patterns.structural.composite.exercise_002;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Shape {
    private List<Shape> components = new ArrayList<>();

    public void addShape(Shape shape) {
        components.add(shape);
    }

    public void removeShape(Shape shape) {
        components.remove(shape);
    }

    @Override
    public void draw() {
        for (Shape component : components) {
            component.draw();

        }

    }
}
