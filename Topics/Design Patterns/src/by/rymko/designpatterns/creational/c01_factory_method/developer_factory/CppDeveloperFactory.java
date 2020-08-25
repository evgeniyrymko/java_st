package by.rymko.designpatterns.creational.c01_factory_method.developer_factory;

import by.rymko.designpatterns.creational.c01_factory_method.developer.CppDeveloper;
import by.rymko.designpatterns.creational.c01_factory_method.developer.Developer;

public class CppDeveloperFactory implements DeveloperFactory {
    @Override
    public Developer createDeveloper() {
        return new CppDeveloper();
    }
}
