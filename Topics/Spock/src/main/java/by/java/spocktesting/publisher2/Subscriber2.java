package by.java.spocktesting.publisher2;

public interface Subscriber2 {
    void receive(String message);

    boolean isActive();
}
