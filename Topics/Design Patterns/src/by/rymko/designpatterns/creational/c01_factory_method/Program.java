package by.rymko.designpatterns.creational.c01_factory_method;

import by.rymko.designpatterns.creational.c01_factory_method.developer.Developer;
import by.rymko.designpatterns.creational.c01_factory_method.developer_factory.CppDeveloperFactory;
import by.rymko.designpatterns.creational.c01_factory_method.developer_factory.DeveloperFactory;
import by.rymko.designpatterns.creational.c01_factory_method.developer_factory.JavaDeveloperFactory;

public class Program {
    public static void main(String[] args) {
        DeveloperFactory developerFactory = createDeveloperBySpecialty("java");
        Developer developer = developerFactory.createDeveloper();
        developer.writeCode();
    }

    static DeveloperFactory createDeveloperBySpecialty(String specialty) {
        if (specialty.equals("java")) {
            return new JavaDeveloperFactory();
        } else if (specialty.equals("c++")) {
            return new CppDeveloperFactory();
        } else {
            throw new RuntimeException(specialty + " is an unknown specialty.");
        }
    }
}
