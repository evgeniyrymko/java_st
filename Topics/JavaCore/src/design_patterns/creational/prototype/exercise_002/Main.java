package design_patterns.creational.prototype.exercise_002;

public class Main {
    public static void main(String[] args) {
        Human origin = new Human(18, "Vasya", "Pupkin");
        System.out.println(origin);
        System.out.println("-----");
        HumanFactory hf = new HumanFactory(origin);
        Human copy1 = hf.copyHuman();
        System.out.println(copy1);
        Human copy2 = hf.copyHuman();
        System.out.println(copy2);

    }
}
