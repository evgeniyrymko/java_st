package design_patterns.creational.abstract_factory.exercise_001;

public interface ProjectTeamFactory {
    Developer getDeveloper();
    Tester getTester();
    ProjectManager getProjectManager();

}
