package by.rymko.designpatterns.behavioral.b_04_mediator;

import by.rymko.designpatterns.behavioral.b_04_mediator.chat.SimpleTextChat;
import by.rymko.designpatterns.behavioral.b_04_mediator.user.Admin;
import by.rymko.designpatterns.behavioral.b_04_mediator.user.SimpleUser;
import by.rymko.designpatterns.behavioral.b_04_mediator.user.User;

public class Program {
    public static void main(String[] args) {
        SimpleTextChat chat = new SimpleTextChat();

        User admin = new Admin("Ivan Ivanovich", chat);
        User user1 = new SimpleUser("Vasya", chat);
        User user2 = new SimpleUser("Petya", chat);

        chat.setAdmin(admin);
        chat.addUser(user1);
        chat.addUser(user2);

//        admin.sendMessage("Hello from admin!!!");
        user1.sendMessage("Hello from user 1!!!");
    }
}
