package design_patterns.creational.abstract_factory.exercise_001.banking_project;

import design_patterns.creational.abstract_factory.exercise_001.Developer;
import design_patterns.creational.abstract_factory.exercise_001.ProjectManager;
import design_patterns.creational.abstract_factory.exercise_001.ProjectTeamFactory;
import design_patterns.creational.abstract_factory.exercise_001.Tester;

public class BankingTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QATester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new BankingPM();
    }
}
