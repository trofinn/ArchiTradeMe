package application.services.event_handlers.enseignements_handlers;

import application.events.Renseignements.RenseignementsDeletedEvent;
import application.port.out.Notification;
import kernel.EventHandler;

public class ModaliteDeletedEventHandler implements EventHandler<RenseignementsDeletedEvent> {

    private final Notification notifications;

    public ModaliteDeletedEventHandler(Notification notifications) {
        this.notifications = notifications;
    }


    @Override
    public void handle(RenseignementsDeletedEvent event) {
        notifications.notify(String.format("Notification of deleted modalité %s of the consultant %s",event.getModalite(), event.getConsultant()));
    }
}
