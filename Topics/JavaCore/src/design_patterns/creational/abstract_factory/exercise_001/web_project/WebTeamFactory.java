package design_patterns.creational.abstract_factory.exercise_001.web_project;

import design_patterns.creational.abstract_factory.exercise_001.Developer;
import design_patterns.creational.abstract_factory.exercise_001.ProjectManager;
import design_patterns.creational.abstract_factory.exercise_001.ProjectTeamFactory;
import design_patterns.creational.abstract_factory.exercise_001.Tester;

public class WebTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public Tester getTester() {
        return new ManualTester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new WebPM();
    }
}
