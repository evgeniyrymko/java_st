package design_patterns.creational.builder.exercise_001;

public class Car {
    private String mark;
    private Transmission transmission;
    private int speed;

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                ", transmission=" + transmission +
                ", speed=" + speed +
                '}';
    }
}

enum Transmission {
    MANUAL, AUTO
}
