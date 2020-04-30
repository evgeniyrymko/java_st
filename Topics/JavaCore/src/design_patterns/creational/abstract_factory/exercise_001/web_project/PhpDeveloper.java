package design_patterns.creational.abstract_factory.exercise_001.web_project;

import design_patterns.creational.abstract_factory.exercise_001.Developer;

public class PhpDeveloper implements Developer {

    @Override
    public void writeCode() {
        System.out.println("PhpDeveloper writes PHP code for web project...");
    }
}
