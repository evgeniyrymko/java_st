package design_patterns.structural.composite.exercise_002;

public class Main {
    public static void main(String[] args) {
        Shape circle01 = new Circle();
        Shape triangle01 = new Triangle();
        Shape square01 = new Square();

        Shape circle02 = new Circle();
        Shape triangle02 = new Triangle();
        Shape square02 = new Square();

        Composite composite01 = new Composite();
        Composite composite02 = new Composite();
        Composite composite00 = new Composite();

        composite00.addShape(composite01);
        composite00.addShape(composite02);

        composite01.addShape(circle01);
        composite01.addShape(triangle01);
        composite01.addShape(square01);

        composite02.addShape(circle02);
        composite02.addShape(triangle02);
        composite02.addShape(square02);

        composite00.draw();
    }
}
