package by.rymko.designpatterns.creational.c05_singleton;

public class ProgramLogger {

    private static ProgramLogger programLogger;

    private static String logFile = "This is log file.\n";

    public static ProgramLogger getProgramLogger() {
        if (programLogger == null){
            programLogger = new ProgramLogger();
        }
        return programLogger;
    }

    private ProgramLogger() {
    }

    public void addLogInfo(String log) {
        logFile += log + "\n";
    }

    public String getLogInfo() {
        return logFile;
    }
}
