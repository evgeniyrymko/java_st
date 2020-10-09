package by.rymko.designpatterns.behavioral.b_01_chain_of_responsibility;

import by.rymko.designpatterns.behavioral.b_01_chain_of_responsibility.notifier.Notifier;
import by.rymko.designpatterns.behavioral.b_01_chain_of_responsibility.notifier.NotifierLevelLow;
import by.rymko.designpatterns.behavioral.b_01_chain_of_responsibility.notifier.NotifierLevelMiddle;
import by.rymko.designpatterns.behavioral.b_01_chain_of_responsibility.notifier.NotifierLevelHigh;
import by.rymko.designpatterns.behavioral.b_01_chain_of_responsibility.priority.Priority;

public class Program {
    public static void main(String[] args) {
        Notifier notifier1 = new NotifierLevelLow(Priority.LOW);
        Notifier notifier2 = new NotifierLevelMiddle(Priority.MIDDLE);
        Notifier notifier3 = new NotifierLevelHigh(Priority.HIGH);

        notifier1.setNextNotifier(notifier2);
        notifier2.setNextNotifier(notifier3);

        notifier1.notify("Example of message to notify with level 1", 1);
        System.out.println("-----");
        notifier1.notify("Example of message to notify with level 2", 2);
        System.out.println("-----");
        notifier1.notify("Example of message to notify with level 3", 3);
    }
}
