package by.java.spocktesting.publisher3;

import java.util.ArrayList;
import java.util.List;

public class Publisher3 {

    private List<Subscriber3> subscribers = new ArrayList<>();

    public void publish(String message) {
        for (Subscriber3 subscriber : subscribers) {
            try {
                String receive = subscriber.receive(message);
                if ("fail".equals(receive)) throw new RuntimeException();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
