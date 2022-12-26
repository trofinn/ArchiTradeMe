package application.events;

import domain.Client;
import domain.Offre;
import kernel.Event;

public class OffertAddedEvent implements Event {
    private final Client client;
    private final Offre offre;

    public OffertAddedEvent(Client client, Offre offre) {
        this.client = client;
        this.offre = offre;
    }

    public Client getClient() {
        return client;
    }

    public Offre getOffre() {
        return offre;
    }
}
