package by.rymko.designpatterns.structural.s_07_proxy;

import by.rymko.designpatterns.structural.s_07_proxy.project.Project;
import by.rymko.designpatterns.structural.s_07_proxy.project.ProjectProxyImpl;

public class Program {
    public static void main(String[] args) {
        Project project = new ProjectProxyImpl("https://github.com/evgeniyrymko/javast");
        project.run();
    }
}
