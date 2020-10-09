package by.rymko.designpatterns.behavioral.b_02_command.command;

import by.rymko.designpatterns.behavioral.b_02_command.database.Database;

public class DeleteDatabaseCommand implements Command {

    private Database database;

    public DeleteDatabaseCommand(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.delete();
    }
}
