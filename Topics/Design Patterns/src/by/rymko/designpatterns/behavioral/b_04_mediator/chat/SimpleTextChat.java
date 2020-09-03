package by.rymko.designpatterns.behavioral.b_04_mediator.chat;

import by.rymko.designpatterns.behavioral.b_04_mediator.user.User;

import java.util.ArrayList;
import java.util.List;

public class SimpleTextChat implements Chat {

    private User admin;

    private List<User> users = new ArrayList<>();

    public SimpleTextChat() {
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void broadcastMessage(String message, User user) {
        for (User user1 : users) {
            user1.getMessage(message);
        }
        admin.getMessage(message);
    }
}
