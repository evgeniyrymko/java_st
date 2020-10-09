package by.rymko.designpatterns.behavioral.b_04_mediator.user;

import by.rymko.designpatterns.behavioral.b_04_mediator.chat.Chat;

public class SimpleUser implements User {

    private String name;

    private Chat chat;

    public SimpleUser(String name, Chat chat) {
        this.name = name;
        this.chat = chat;
    }

    public String getName() {
        return name;
    }

    @Override
    public void sendMessage(String message) {
        System.out.printf("User %s sent message: %s.%n", name, message);
        System.out.println("-----");
        chat.broadcastMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.printf("User %s received message: %s.%n", name, message);
    }
}
