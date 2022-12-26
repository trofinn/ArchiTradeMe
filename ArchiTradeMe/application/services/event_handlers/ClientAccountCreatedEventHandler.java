package application.services.event_handlers;

import application.events.ClientAccountCreatedEvent;
import application.port.out.Notification;
import kernel.EventHandler;

public class ClientAccountCreatedEventHandler  implements EventHandler<ClientAccountCreatedEvent> {

    private final Notification notifications;

    public ClientAccountCreatedEventHandler(Notification notifications) {
        this.notifications = notifications;
    }

    @Override
    public void handle(ClientAccountCreatedEvent event) {
        notifications.notify(String.format("Notification of the client account creation with email %s",event.getEmail()));
    }
}
