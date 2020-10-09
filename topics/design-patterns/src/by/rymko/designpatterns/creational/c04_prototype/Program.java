package by.rymko.designpatterns.creational.c04_prototype;

import by.rymko.designpatterns.creational.c04_prototype.factory.ProjectFactory;
import by.rymko.designpatterns.creational.c04_prototype.project.Project;

public class Program {

    public static void main(String[] args) {

        Project original = new Project(1, "Project one", "Hello World");
        System.out.println(original);
        System.out.println("-----");
        ProjectFactory factory = new ProjectFactory(original);
        Project copy = factory.cloneProject();
        System.out.println(copy);
    }
}
