package application.services.event_handlers.enseignements_handlers;

import application.events.Renseignements.DispoAddedEvent;
import application.port.out.Notification;
import kernel.EventHandler;

public class DispoAddedEventHandler implements EventHandler<DispoAddedEvent> {

    private final Notification notifications;

    public DispoAddedEventHandler(Notification notifications) {
        this.notifications = notifications;
    }


    @Override
    public void handle(DispoAddedEvent event) {
        notifications.notify(String.format("Notification of new added disponibilité %s of the consultant %s",event.getDisponibilite(), event.getConsultant()));
    }
}