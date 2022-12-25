package application.services;

import application.events.ConsultantAccountCreatedEvent;
import application.port.out.Notification;
import kernel.EventHandler;

public class ConsultantAccountCreatedEventHandler implements EventHandler<ConsultantAccountCreatedEvent> {

    private final Notification notifications;

    public ConsultantAccountCreatedEventHandler(Notification notifications) {
        this.notifications = notifications;
    }

    @Override
    public void handle(ConsultantAccountCreatedEvent event) {
        notifications.notify(String.format("Notification of the consultant account creation with email %s",event.getEmail()));
    }
}
