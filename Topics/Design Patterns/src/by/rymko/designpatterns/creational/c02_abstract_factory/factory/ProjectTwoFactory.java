package by.rymko.designpatterns.creational.c02_abstract_factory.factory;

import by.rymko.designpatterns.creational.c02_abstract_factory.developer.CppDeveloper;
import by.rymko.designpatterns.creational.c02_abstract_factory.developer.Developer;
import by.rymko.designpatterns.creational.c02_abstract_factory.manager.Manager;
import by.rymko.designpatterns.creational.c02_abstract_factory.manager.ProjectTwoManager;
import by.rymko.designpatterns.creational.c02_abstract_factory.tester.AutomationTester;
import by.rymko.designpatterns.creational.c02_abstract_factory.tester.Tester;

public class ProjectTwoFactory implements TeamFactory {

    @Override
    public Developer createDeveloper() {
        return new CppDeveloper();
    }

    @Override
    public Tester createTester() {
        return new AutomationTester();
    }

    @Override
    public Manager createManager() {
        return new ProjectTwoManager();
    }
}
