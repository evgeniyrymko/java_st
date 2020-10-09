package by.rymko.designpatterns.behavioral.b_01_chain_of_responsibility.notifier;

public abstract class Notifier {

    private int priority;

    private Notifier nextNotifier;

    public Notifier(int priority) {
        this.priority = priority;
    }

    public void setNextNotifier(Notifier nextNotifier) {
        this.nextNotifier = nextNotifier;
    }

    public void notify(String message, int level) {
        if (level >= priority) {
            write(message);
        }
        if (nextNotifier != null) {
            nextNotifier.notify(message, level);
        }
    }

    public abstract void write(String message);

}
