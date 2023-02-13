package application.services.event_handlers.enseignements_handlers;

import application.events.Renseignements.ModaliteDeletedEvent;
import application.port.out.Notification;
import kernel.EventHandler;

public class ModaliteDeletedEventHandler implements EventHandler<ModaliteDeletedEvent> {

    private final Notification notifications;

    public ModaliteDeletedEventHandler(Notification notifications) {
        this.notifications = notifications;
    }


    @Override
    public void handle(ModaliteDeletedEvent event) {
        notifications.notify(String.format("Notification of deleted modalité %s of the consultant %s",event.getModalite(), event.getConsultant()));
    }
}
