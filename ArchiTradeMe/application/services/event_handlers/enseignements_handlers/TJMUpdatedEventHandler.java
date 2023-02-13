package application.services.event_handlers.enseignements_handlers;

import application.events.Renseignements.TJMUpdatedEvent;
import application.port.out.Notification;
import kernel.EventHandler;

public class TJMUpdatedEventHandler implements EventHandler<TJMUpdatedEvent> {

    private final Notification notifications;

    public TJMUpdatedEventHandler(Notification notifications) {
        this.notifications = notifications;
    }


    @Override
    public void handle(TJMUpdatedEvent event) {
        notifications.notify(String.format("Notification of updated TJM = %s of the consultant %s",event.getTJM(), event.getConsultant()));
    }
}
