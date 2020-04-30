package design_patterns.creational.builder.exercise_001;

public class CarBuilder {
    private String m="empty model";
    private Transmission t=Transmission.MANUAL;
    private int s=0;

    public CarBuilder buildMark(String m) {
        this.m = m;
        return this;
    }

    public CarBuilder buildTransmission(Transmission t) {
        this.t = t;
        return this;
    }

    public CarBuilder buildSpeed(int s) {
        this.s = s;
        return this;
    }

    public Car buildCar() {
        Car car = new Car();
        car.setMark(m);
        car.setTransmission(t);
        car.setSpeed(s);
        return car;
    }
}
