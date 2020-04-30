package design_patterns.creational.prototype.exercise_001;

public class Main {
    public static void main(String[] args) {
        Project origin = new Project(1, "Project 123", "Project description...");
        ProjectFactory pf = new ProjectFactory(origin);
        Project copy1 = pf.cloneProject();
        System.out.println(copy1);
        Project copy2 = pf.cloneProject();
        System.out.println(copy2);
    }
}
