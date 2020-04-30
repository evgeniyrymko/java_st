package design_patterns.creational.prototype.exercise_002;

public class Human implements Copyable {
    private int age;
    private String firstName;
    private String lastName;

    public Human(int age, String firstName, String lastName) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public Human copy() {
        Human copy = new Human(age, firstName, lastName);
        return copy;
    }
}
