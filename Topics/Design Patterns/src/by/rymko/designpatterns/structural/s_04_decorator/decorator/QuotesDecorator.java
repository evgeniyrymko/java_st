package by.rymko.designpatterns.structural.s_04_decorator.decorator;

import by.rymko.designpatterns.structural.s_04_decorator.printer.PrinterInterface;

public class QuotesDecorator extends Decorator {

    public QuotesDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.print("\"");
        component.print();
        System.out.print("\"");
    }
}
