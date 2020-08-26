package by.rymko.designpatterns.structural.s_02_bridge.developer;

public class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Java developer writes Java code.");
    }
}
