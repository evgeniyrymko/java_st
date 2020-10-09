package by.rymko.designpatterns.creational.c02_abstract_factory;

import by.rymko.designpatterns.creational.c02_abstract_factory.developer.Developer;
import by.rymko.designpatterns.creational.c02_abstract_factory.factory.ProjectOneFactory;
import by.rymko.designpatterns.creational.c02_abstract_factory.factory.ProjectTwoFactory;
import by.rymko.designpatterns.creational.c02_abstract_factory.factory.TeamFactory;
import by.rymko.designpatterns.creational.c02_abstract_factory.manager.Manager;
import by.rymko.designpatterns.creational.c02_abstract_factory.tester.Tester;

public class Program {
    public static void main(String[] args) {

        TeamFactory factory = new ProjectOneFactory();

        Developer developer = factory.createDeveloper();
        Tester tester = factory.createTester();
        Manager manager = factory.createManager();

        System.out.println("Project 1");
        developer.writeCode();
        tester.testCode();
        manager.manageProject();
        System.out.println("------");

        TeamFactory factory2 = new ProjectTwoFactory();

        Developer developer2 = factory2.createDeveloper();
        Tester tester2 = factory2.createTester();
        Manager manager2 = factory2.createManager();

        System.out.println("Project 2");
        developer2.writeCode();
        tester2.testCode();
        manager2.manageProject();
        System.out.println("------");
    }
}
