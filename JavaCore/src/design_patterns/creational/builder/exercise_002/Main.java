package design_patterns.creational.builder.exercise_002;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        director.setCarBuilder(new FordMondeoBuilder());
        Car car = director.buildCar();
        System.out.println(car);
    }
}
