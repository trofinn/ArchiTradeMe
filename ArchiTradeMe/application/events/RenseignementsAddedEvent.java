package application.events;

import com.fasterxml.jackson.annotation.JsonFormat;
import domain.Competence;
import domain.Consultant;
import domain.Modalite;
import kernel.Event;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class RenseignementsAddedEvent implements Event {
    private final Consultant consultant;

    private Competence competence;
    private LocalDateTime disponibilite;
    private Modalite modalite;
    private String TJM;

    public RenseignementsAddedEvent(Consultant consultant, Competence competence) {
        this.consultant = consultant;
        this.competence = competence;
    }

    public RenseignementsAddedEvent(Consultant consultant, LocalDateTime disponibilite) {
        this.consultant = consultant;
        this.disponibilite = disponibilite;
    }

    public RenseignementsAddedEvent(Consultant consultant, Modalite modalite) {
        this.consultant = consultant;
        this.modalite = modalite;
    }

    public RenseignementsAddedEvent(Consultant consultant, String TJM) {
        this.consultant = consultant;
        this.TJM = TJM;
    }

    public Consultant getConsultant() {
        return consultant;
    }

    public Competence getCompetence() {
        return competence;
    }

    public LocalDateTime getDisponibilite() {
        return disponibilite;
    }

    public Modalite getModalite() {
        return modalite;
    }

    public String getTJM() {
        return TJM;
    }
}
