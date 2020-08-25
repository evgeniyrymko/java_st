package by.rymko.designpatterns.creational.c04_prototype.factory;

import by.rymko.designpatterns.creational.c04_prototype.project.Project;

public class ProjectFactory {
    Project project;

    public ProjectFactory(Project project) {
        this.project = project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Project cloneProject(){
        return (Project) this.project.copy();
    }
}
