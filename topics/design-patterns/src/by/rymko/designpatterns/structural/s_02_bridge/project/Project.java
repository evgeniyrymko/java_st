package by.rymko.designpatterns.structural.s_02_bridge.project;

import by.rymko.designpatterns.structural.s_02_bridge.developer.Developer;

public abstract class Project {

    Developer developer;

    public Project(Developer developer) {
        this.developer = developer;
    }

    public abstract void developProject();
}
