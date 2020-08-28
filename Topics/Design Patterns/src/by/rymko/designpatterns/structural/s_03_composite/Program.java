package by.rymko.designpatterns.structural.s_03_composite;

import by.rymko.designpatterns.structural.s_03_composite.shape.Circle;
import by.rymko.designpatterns.structural.s_03_composite.shape.Rectangle;
import by.rymko.designpatterns.structural.s_03_composite.shape.Shape;
import by.rymko.designpatterns.structural.s_03_composite.shape.Triangle;

public class Program {
    public static void main(String[] args) {
        Composite compositeMain = new Composite();
        Composite compositeChild1 = new Composite();
        Composite compositeChild2 = new Composite();

        Shape circle1 = new Circle();
        Shape circle2 = new Circle();

        Shape rectangle1 = new Rectangle();
        Shape rectangle2 = new Rectangle();

        Shape triangle1 = new Triangle();
        Shape triangle2 = new Triangle();

        compositeChild1.addComponent(circle1);
        compositeChild1.addComponent(rectangle1);
        compositeChild1.addComponent(triangle1);

        compositeChild2.addComponent(circle2);
        compositeChild2.addComponent(rectangle2);
        compositeChild2.addComponent(triangle2);

        compositeMain.addComponent(compositeChild1);
        compositeMain.addComponent(compositeChild2);

        compositeMain.draw();
    }
}
