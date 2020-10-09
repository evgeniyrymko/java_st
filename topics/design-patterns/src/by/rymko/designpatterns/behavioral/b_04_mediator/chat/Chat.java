package by.rymko.designpatterns.behavioral.b_04_mediator.chat;

import by.rymko.designpatterns.behavioral.b_04_mediator.user.User;

public interface Chat {

    void broadcastMessage(String message, User user);
}
