package design_patterns.creational.builder.exercise_002;

public class SubaruBuilder extends CarBuilder {
    @Override
    void buildMark() {
        car.setMark("Subaru");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);
    }

    @Override
    void buildSpeed() {
        car.setSpeed(250);
    }
}
