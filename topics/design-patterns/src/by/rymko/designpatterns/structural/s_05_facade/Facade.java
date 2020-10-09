package by.rymko.designpatterns.structural.s_05_facade;

import by.rymko.designpatterns.structural.s_05_facade.parts.BugTracker;
import by.rymko.designpatterns.structural.s_05_facade.parts.Developer;
import by.rymko.designpatterns.structural.s_05_facade.parts.Job;

public class Facade {

    private Job job = new Job();

    private BugTracker bugTracker = new BugTracker();

    private Developer developer = new Developer();

    public void doComplexProcessViaFacade() {
        job.doJob();
        bugTracker.startSprint();
        developer.doJobBeforeDeadline(bugTracker);
    }
}
