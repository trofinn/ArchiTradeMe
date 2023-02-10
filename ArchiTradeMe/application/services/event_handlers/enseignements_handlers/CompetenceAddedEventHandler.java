package application.services.event_handlers.enseignements_handlers;

import application.events.Renseignements.RenseignementsAddedEvent;
import application.port.out.Notification;
import kernel.EventHandler;

public class CompetenceAddedEventHandler implements EventHandler<RenseignementsAddedEvent> {

    private final Notification notifications;

    public CompetenceAddedEventHandler(Notification notifications) {
        this.notifications = notifications;
    }


    @Override
    public void handle(RenseignementsAddedEvent event) {
        notifications.notify(String.format("Notification of new added competence %s of the consultant %s",event.getCompetence(), event.getConsultant()));
    }
}
