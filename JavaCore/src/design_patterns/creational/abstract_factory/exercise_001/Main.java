package design_patterns.creational.abstract_factory.exercise_001;

import design_patterns.creational.abstract_factory.exercise_001.banking_project.BankingTeamFactory;
import design_patterns.creational.abstract_factory.exercise_001.web_project.WebTeamFactory;

public class Main {
    public static void main(String[] args) {
        ProjectTeamFactory ptf = new WebTeamFactory();
        Developer dev = ptf.getDeveloper();
        Tester tester = ptf.getTester();
        ProjectManager pm = ptf.getProjectManager();
        dev.writeCode();
        tester.testCode();
        pm.manageProject();
    }
}
