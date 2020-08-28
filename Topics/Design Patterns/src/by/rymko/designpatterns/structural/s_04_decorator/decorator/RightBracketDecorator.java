package by.rymko.designpatterns.structural.s_04_decorator.decorator;

import by.rymko.designpatterns.structural.s_04_decorator.printer.PrinterInterface;

public class RightBracketDecorator extends Decorator {

    public RightBracketDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        component.print();
        System.out.print(")");
    }
}
