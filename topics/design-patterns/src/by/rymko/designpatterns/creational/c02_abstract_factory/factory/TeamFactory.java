package by.rymko.designpatterns.creational.c02_abstract_factory.factory;

import by.rymko.designpatterns.creational.c02_abstract_factory.developer.Developer;
import by.rymko.designpatterns.creational.c02_abstract_factory.manager.Manager;
import by.rymko.designpatterns.creational.c02_abstract_factory.tester.Tester;

public interface TeamFactory {

    Developer createDeveloper();

    Tester createTester();

    Manager createManager();
}
