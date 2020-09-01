package by.rymko.designpatterns.behavioral.b_02_command;

import by.rymko.designpatterns.behavioral.b_02_command.command.DeleteDatabaseCommand;
import by.rymko.designpatterns.behavioral.b_02_command.command.InsertDatabaseCommand;
import by.rymko.designpatterns.behavioral.b_02_command.command.SelectDatabaseCommand;
import by.rymko.designpatterns.behavioral.b_02_command.command.UpdateDatabaseCommand;
import by.rymko.designpatterns.behavioral.b_02_command.database.Database;
import by.rymko.designpatterns.behavioral.b_02_command.developer.Developer;

public class Program {
    public static void main(String[] args) {
        Database database = new Database();

        Developer developer = new Developer(
                new InsertDatabaseCommand(database),
                new UpdateDatabaseCommand(database),
                new SelectDatabaseCommand(database),
                new DeleteDatabaseCommand(database)
        );

        developer.insertRecord();
        developer.updateRecord();
        developer.selectRecord();
        developer.deleteRecord();

    }
}
