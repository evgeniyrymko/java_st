package by.rymko.designpatterns.creational.c02_abstract_factory.factory;

import by.rymko.designpatterns.creational.c02_abstract_factory.developer.Developer;
import by.rymko.designpatterns.creational.c02_abstract_factory.developer.JavaDeveloper;
import by.rymko.designpatterns.creational.c02_abstract_factory.manager.Manager;
import by.rymko.designpatterns.creational.c02_abstract_factory.manager.ProjectOneManager;
import by.rymko.designpatterns.creational.c02_abstract_factory.tester.ManualTester;
import by.rymko.designpatterns.creational.c02_abstract_factory.tester.Tester;

public class ProjectOneFactory implements TeamFactory {

    @Override
    public Developer createDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester createTester() {
        return new ManualTester();
    }

    @Override
    public Manager createManager() {
        return new ProjectOneManager();
    }
}
