package by.rymko.designpatterns.structural.s_04_decorator.printer;

public class Printer implements PrinterInterface {

    private String message;

    public Printer(String message) {
        this.message = message;
    }

    @Override
    public void print() {
        System.out.print(message);
    }
}
