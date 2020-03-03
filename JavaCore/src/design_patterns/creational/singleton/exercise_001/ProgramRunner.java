package design_patterns.creational.singleton.exercise_001;

public class ProgramRunner {
    public static void main(String[] args) {
        ProgramLogger.getInstance().addLogInfo("First log");
        ProgramLogger.getInstance().addLogInfo("Second log");
        ProgramLogger.getInstance().addLogInfo("Third log");

        ProgramLogger.getInstance().showLogFile();

    }
}
