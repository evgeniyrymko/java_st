package design_patterns.creational.abstract_factory.exercise_001.banking_project;

import design_patterns.creational.abstract_factory.exercise_001.ProjectManager;

public class BankingPM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("Banking PM manages banking project...");
    }
}
