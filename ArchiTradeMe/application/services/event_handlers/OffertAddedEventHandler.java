package application.services.event_handlers;

import application.events.ConsultantAccountCreatedEvent;
import application.events.OffertAddedEvent;
import application.port.out.Notification;
import kernel.EventHandler;

public class OffertAddedEventHandler implements EventHandler<OffertAddedEvent> {

    private final Notification notifications;

    public OffertAddedEventHandler(Notification notifications) {
        this.notifications = notifications;
    }

    @Override
    public void handle(OffertAddedEvent event) {
        notifications.notify(String.format("Notification of new added/deleted offert %s from the client %s",event.getOffre(),event.getClient().getEmail()));
    }
}
