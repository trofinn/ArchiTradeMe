package application.services.event_handlers.enseignements_handlers;

import application.events.Renseignements.CompetenceDeletedEvent;
import application.port.out.Notification;
import kernel.EventHandler;

public class CompetenceDeletedEventHandler implements EventHandler<CompetenceDeletedEvent> {

    private final Notification notifications;

    public CompetenceDeletedEventHandler(Notification notifications) {
        this.notifications = notifications;
    }


    @Override
    public void handle(CompetenceDeletedEvent event) {
        notifications.notify(String.format("Notification of deleted competence %s of the consultant %s",event.getCompetence(), event.getConsultant()));
    }
}
