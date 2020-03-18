package design_patterns.creational.abstract_factory.exercise_001.banking_project;

import design_patterns.creational.abstract_factory.exercise_001.Developer;

public class JavaDeveloper implements Developer {

    @Override
    public void writeCode() {
        System.out.println("Java developer writes Java code for banking project...");
    }
}
