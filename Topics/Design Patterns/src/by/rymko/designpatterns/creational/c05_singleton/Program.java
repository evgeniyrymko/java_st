package by.rymko.designpatterns.creational.c05_singleton;

public class Program {

    public static void main(String[] args) {
        ProgramLogger logger = ProgramLogger.getProgramLogger();
        System.out.println(logger);

//        ProgramLogger logger1 = ProgramLogger.getProgramLogger();
//        System.out.println(logger1);

//        ProgramLogger logger2 = ProgramLogger.getProgramLogger();
//        System.out.println(logger2);

        logger.addLogInfo("Log 1");
        logger.addLogInfo("Log 2");
        System.out.println(logger.getLogInfo());

    }
}
