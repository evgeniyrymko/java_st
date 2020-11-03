package by.rymko.designpatterns.structural.s_05_facade.parts;

public class BugTracker {

    private boolean activeSprint;

    public boolean isActiveSprint() {
        return activeSprint;
    }

    public void startSprint() {
        activeSprint = true;
        System.out.println("Sprint is active");
    }

    public void finishSprint() {
        activeSprint = false;
        System.out.println("Sprint is over");
    }
}