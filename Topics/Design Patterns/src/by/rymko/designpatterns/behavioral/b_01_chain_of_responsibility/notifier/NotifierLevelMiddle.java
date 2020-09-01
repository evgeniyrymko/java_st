package by.rymko.designpatterns.behavioral.b_01_chain_of_responsibility.notifier;

public class NotifierLevelMiddle extends Notifier {

    public NotifierLevelMiddle(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.printf("Notifying message on level 2: %s.%n", message);
    }
}
