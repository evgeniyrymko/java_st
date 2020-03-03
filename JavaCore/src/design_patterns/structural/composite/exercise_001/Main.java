package design_patterns.structural.composite.exercise_001;

public class Main {
    public static void main(String[] args) {
        Team team = new Team();

        Developer JavaDeveloper01 = new JavaDeveloper();
        Developer JavaDeveloper02 = new JavaDeveloper();
        Developer CppDeveloper = new CppDeveloper();

        team.addDeveloper(JavaDeveloper01);
        team.addDeveloper(JavaDeveloper02);
        team.addDeveloper(CppDeveloper);

        team.createProject();
    }
}
