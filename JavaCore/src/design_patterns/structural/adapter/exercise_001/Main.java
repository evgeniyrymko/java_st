package design_patterns.structural.adapter.exercise_001;

public class Main {
    public static void main(String[] args) {
        Database db = new AdapterJavaToDatabase();
        db.insert();
        db.update();
        db.select();
        db.remove();

    }
}
