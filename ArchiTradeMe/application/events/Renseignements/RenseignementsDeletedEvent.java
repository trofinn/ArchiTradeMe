package application.events.Renseignements;

import domain.Competence;
import domain.Consultant;
import domain.Modalite;
import kernel.Event;

import java.time.LocalDateTime;

public class RenseignementsDeletedEvent implements Event {
    private final Consultant consultant;

    private Competence competence;
    private LocalDateTime disponibilite;
    private Modalite modalite;
    private String TJM;

    public RenseignementsDeletedEvent(Consultant consultant, Competence competence) {
        this.consultant = consultant;
        this.competence = competence;
    }

    public RenseignementsDeletedEvent(Consultant consultant, LocalDateTime disponibilite) {
        this.consultant = consultant;
        this.disponibilite = disponibilite;
    }

    public RenseignementsDeletedEvent(Consultant consultant, Modalite modalite) {
        this.consultant = consultant;
        this.modalite = modalite;
    }

    public RenseignementsDeletedEvent(Consultant consultant, String TJM) {
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
