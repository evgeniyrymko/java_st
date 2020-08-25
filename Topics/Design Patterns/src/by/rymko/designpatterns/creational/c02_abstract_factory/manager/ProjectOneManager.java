package by.rymko.designpatterns.creational.c02_abstract_factory.manager;

public class ProjectOneManager implements Manager {
    @Override
    public void manageProject() {
        System.out.println("Manager 1 manages project 1");
    }
}
