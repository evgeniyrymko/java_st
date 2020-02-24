package design_patterns.creational.prototype.exercise_002;

public class HumanFactory {
    private Human human;

    public HumanFactory(Human human) {
        this.human = human;
    }

    public Human copyHuman() {
        return human.copy();
    }
}
