package by.rymko.designpatterns.structural.s_04_decorator;

import by.rymko.designpatterns.structural.s_04_decorator.decorator.LeftBracketDecorator;
import by.rymko.designpatterns.structural.s_04_decorator.decorator.QuotesDecorator;
import by.rymko.designpatterns.structural.s_04_decorator.decorator.RightBracketDecorator;
import by.rymko.designpatterns.structural.s_04_decorator.printer.Printer;
import by.rymko.designpatterns.structural.s_04_decorator.printer.PrinterInterface;

public class Program {
    public static void main(String[] args) {

//        PrinterInterface printer = new Printer("This printer works!");
//        printer.print();

        PrinterInterface printerDecorator = new QuotesDecorator(new LeftBracketDecorator(new RightBracketDecorator(new Printer("Hello world from printer!"))));
        printerDecorator.print();

    }
}
