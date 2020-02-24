package design_patterns.creational.builder.exercise_001;

public class Main {
    public static void main(String[] args) {
        Car car1 =new CarBuilder().buildMark("Audi").buildTransmission(Transmission.AUTO).buildSpeed(100).buildCar();
        System.out.println(car1);
        Car car2 = new CarBuilder().buildMark("BMW").buildSpeed(200).buildCar();
        System.out.println(car2);
    }
}
