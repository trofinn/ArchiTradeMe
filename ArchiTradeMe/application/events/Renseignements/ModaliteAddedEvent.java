package application.events.Renseignements;

import domain.Consultant;
import domain.Modalite;
import kernel.Event;

public class ModaliteAddedEvent implements Event {
    private final Consultant consultant;
    private Modalite modalite;

    public ModaliteAddedEvent(Consultant consultant, Modalite modalite) {
        this.consultant = consultant;
        this.modalite = modalite;
    }

    public Consultant getConsultant() {
        return consultant;
    }

    public Modalite getModalite() {
        return modalite;
    }
}
