package application.events.Renseignements;

import domain.Consultant;
import kernel.Event;

public class TJMUpdatedEvent implements Event {
    private final Consultant consultant;
    private String TJM;



    public TJMUpdatedEvent(Consultant consultant, String TJM) {
        this.consultant = consultant;
        this.TJM = TJM;
    }

    public String getTJM() {
        return TJM;
    }

    public Consultant getConsultant() {
        return consultant;
    }
}
