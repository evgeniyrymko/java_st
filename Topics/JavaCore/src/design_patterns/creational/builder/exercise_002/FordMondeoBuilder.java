package design_patterns.creational.builder.exercise_002;

public class FordMondeoBuilder extends CarBuilder {
    @Override
    void buildMark() {
        car.setMark("Ford Mondeo");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.AUTO);
    }

    @Override
    void buildSpeed() {
        car.setSpeed(200);
    }
}
