package by.java.spocktesting.publisher1;

import java.util.ArrayList;
import java.util.List;

public class Publisher1 {
    private List<Subscriber1> subscribers = new ArrayList<>();

    public void publish(String message) {
        for (Subscriber1 subscriber : subscribers) {
            try {
                subscriber.receive(message);
            } catch (Exception e) {
            }
        }
    }
}
