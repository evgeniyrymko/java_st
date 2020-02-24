package design_patterns.creational.prototype.exercise_001;

public class ProjectFactory {
    Project project;

    public ProjectFactory(Project project) {
        this.project = project;
    }

    public Project cloneProject(){
        return project.copy();
    }
}
