package application.services.event_handlers.enseignements_handlers;

import application.events.Renseignements.RenseignementsAddedEvent;
import application.port.out.Notification;
import kernel.EventHandler;

public class ModaliteAddedEventHandler implements EventHandler<RenseignementsAddedEvent> {

    private final Notification notifications;

    public ModaliteAddedEventHandler(Notification notifications) {
        this.notifications = notifications;
    }


    @Override
    public void handle(RenseignementsAddedEvent event) {
        notifications.notify(String.format("Notification of new added modalité %s of the consultant %s",event.getModalite(), event.getConsultant()));
    }
}
