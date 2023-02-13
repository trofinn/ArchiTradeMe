package application.services.event_handlers.enseignements_handlers;

import application.events.Renseignements.DispoDeletedEvent;
import application.port.out.Notification;
import kernel.EventHandler;

public class DispoDeletedEventHandler implements EventHandler<DispoDeletedEvent> {

    private final Notification notifications;

    public DispoDeletedEventHandler(Notification notifications) {
        this.notifications = notifications;
    }


    @Override
    public void handle(DispoDeletedEvent event) {
        notifications.notify(String.format("Notification of deleted disponibilité %s of the consultant %s",event.getDisponibilite(), event.getConsultant()));
    }
}
