package by.rymko.designpatterns.structural.s_02_bridge.developer;

public class CppDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("C++ developer writes C++ code.");
    }
}
