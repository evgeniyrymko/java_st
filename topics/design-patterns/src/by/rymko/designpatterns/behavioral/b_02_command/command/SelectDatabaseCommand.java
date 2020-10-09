package by.rymko.designpatterns.behavioral.b_02_command.command;

import by.rymko.designpatterns.behavioral.b_02_command.database.Database;

public class SelectDatabaseCommand implements Command {

    private Database database;

    public SelectDatabaseCommand(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.select();
    }
}