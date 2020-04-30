package design_patterns.creational.builder.exercise_002;

public abstract class CarBuilder {
    Car car;

    public void createCar() {
        car = new Car();
    }

    abstract void buildMark();

    abstract void buildTransmission();

    abstract void buildSpeed();

    public Car getCar() {
        return car;
    }
}
