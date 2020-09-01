package by.rymko.designpatterns.behavioral.b_01_chain_of_responsibility.notifier;

public class NotifierLevelLow extends Notifier {

    public NotifierLevelLow(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.printf("Notifying message on level 1: %s.%n", message);
    }
}
