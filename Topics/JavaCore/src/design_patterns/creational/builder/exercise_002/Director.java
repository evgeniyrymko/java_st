package design_patterns.creational.builder.exercise_002;

public class Director {
    CarBuilder carBuilder;

    public void setCarBuilder(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public Car buildCar() {
        carBuilder.createCar();
        carBuilder.buildMark();
        carBuilder.buildTransmission();
        carBuilder.buildSpeed();
        Car car = carBuilder.getCar();
        return car;
    }
}
