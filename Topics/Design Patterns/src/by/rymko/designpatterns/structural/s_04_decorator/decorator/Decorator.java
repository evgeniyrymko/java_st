package by.rymko.designpatterns.structural.s_04_decorator.decorator;

import by.rymko.designpatterns.structural.s_04_decorator.printer.PrinterInterface;

public abstract class Decorator implements PrinterInterface {

    PrinterInterface component;


    public Decorator(PrinterInterface component) {
        this.component = component;
    }
}
