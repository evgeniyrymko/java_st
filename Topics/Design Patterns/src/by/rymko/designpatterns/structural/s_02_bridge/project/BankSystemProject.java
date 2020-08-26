package by.rymko.designpatterns.structural.s_02_bridge.project;

import by.rymko.designpatterns.structural.s_02_bridge.developer.Developer;

public class BankSystemProject extends Project {

    public BankSystemProject(Developer developer) {
        super(developer);
    }

    @Override
    public void developProject() {
        System.out.println("Developing Bank System Project.");
        developer.writeCode();
    }
}
