package application.events.Renseignements;

import domain.Consultant;
import kernel.Event;

import java.time.LocalDateTime;

public class DispoDeletedEvent implements Event {
    private final Consultant consultant;
    private LocalDateTime disponibilite;

    public DispoDeletedEvent(Consultant consultant, LocalDateTime disponibilite) {
        this.consultant = consultant;
        this.disponibilite = disponibilite;
    }

    public Consultant getConsultant() {
        return consultant;
    }

    public LocalDateTime getDisponibilite() {
        return disponibilite;
    }
}
