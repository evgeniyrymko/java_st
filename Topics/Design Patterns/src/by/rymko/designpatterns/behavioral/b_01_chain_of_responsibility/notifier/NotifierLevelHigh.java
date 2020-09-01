package by.rymko.designpatterns.behavioral.b_01_chain_of_responsibility.notifier;

public class NotifierLevelHigh extends Notifier {

    public NotifierLevelHigh(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.printf("Notifying message on level 3: %s.%n", message);
    }
}
