package application.services.event_handlers;
import application.events.RenseignementsAddedEvent;
import application.port.out.Notification;
import kernel.EventHandler;

public class RenseignementsAddedEventHandler implements EventHandler<RenseignementsAddedEvent> {

    private final Notification notifications;

    public RenseignementsAddedEventHandler(Notification notifications) {
        this.notifications = notifications;
    }


    @Override
    public void handle(RenseignementsAddedEvent event) {
        notifications.notify(String.format("Notification of new added info about the consultant %s",event.getConsultant()));
    }
}
