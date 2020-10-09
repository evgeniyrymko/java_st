package by.java.spocktesting.publisher2;

import java.util.ArrayList;
import java.util.List;

public class Publisher2 {

    private List<Subscriber2> subscribers = new ArrayList<>();

    public void publish(String message) {
        for (Subscriber2 subscriber : subscribers) {
            try {
                if (subscriber.isActive()) {
                    subscriber.receive(message);
                }
            } catch (Exception e) {
            }
        }
    }
}
