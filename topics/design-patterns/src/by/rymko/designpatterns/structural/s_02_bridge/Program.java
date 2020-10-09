package by.rymko.designpatterns.structural.s_02_bridge;

import by.rymko.designpatterns.structural.s_02_bridge.developer.CppDeveloper;
import by.rymko.designpatterns.structural.s_02_bridge.developer.JavaDeveloper;
import by.rymko.designpatterns.structural.s_02_bridge.project.BankSystemProject;
import by.rymko.designpatterns.structural.s_02_bridge.project.Project;
import by.rymko.designpatterns.structural.s_02_bridge.project.StockExchangeProject;

public class Program {
    public static void main(String[] args) {

        Project project1 = new BankSystemProject(new JavaDeveloper());
        project1.developProject();

        Project project2 = new StockExchangeProject(new CppDeveloper());
        project2.developProject();
    }
}
