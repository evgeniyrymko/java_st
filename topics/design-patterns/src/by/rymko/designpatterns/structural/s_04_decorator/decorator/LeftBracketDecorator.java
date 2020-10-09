package by.rymko.designpatterns.structural.s_04_decorator.decorator;

import by.rymko.designpatterns.structural.s_04_decorator.printer.PrinterInterface;

public class LeftBracketDecorator extends Decorator {

    public LeftBracketDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.print("(");
        component.print();
    }
}
