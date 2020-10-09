package by.rymko.designpatterns.structural.s_01_adapter;

public class Program {
    public static void main(String[] args) {

        Database db = new JavaApplicationDatabaseAdapter();

        db.insert();
        db.update();
        db.select();
        db.remove();
    }
}
