package design_patterns.creational.abstract_factory.exercise_001.web_project;

import design_patterns.creational.abstract_factory.exercise_001.ProjectManager;

public class WebPM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("Web PM manages web project...");
    }
}
