package design_patterns.creational.singleton.exercise_001;

public class ProgramLogger {
    private static ProgramLogger instance;
    private static String logFile = "This is log file. \n\n";

    public static ProgramLogger getInstance() {
        if (instance == null) {
            instance = new ProgramLogger();
        }
        return instance;
    }

    private ProgramLogger() {
    }

    public void addLogInfo( String logInfo) {
        logFile += logInfo + "\n";
    }

    public void showLogFile() {
        System.out.println(logFile);
    }

}
