package by.rymko.designpatterns.creational.c01_factory_method.developer_factory;

import by.rymko.designpatterns.creational.c01_factory_method.developer.Developer;
import by.rymko.designpatterns.creational.c01_factory_method.developer.JavaDeveloper;

public class JavaDeveloperFactory implements DeveloperFactory {
    @Override
    public Developer createDeveloper() {
        return new JavaDeveloper();
    }
}
