package design_patterns.creational.factory_method.exercise_001;

public class Program {
    public static void main(String[] args) {
        DeveloperFactory df = Program.createDeveloperBySpeciality("java");
        Developer dev = df.createDeveloper();
        dev.writeCode();
    }

    static DeveloperFactory createDeveloperBySpeciality(String speciality) {
        if (speciality.equalsIgnoreCase("java")) {
            return new JavaDeveloperFactory();
        } else if (speciality.equalsIgnoreCase("cpp")) {
            return new CppDeveloperFactory();
        } else {
            throw new RuntimeException(speciality + " does not exist");
        }
    }
}
