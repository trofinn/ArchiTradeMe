package application.port.in.DTOs;

import domain.Competence;
import domain.Consultant;
import domain.Modalite;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class RenseignementsCommand {

    @NotNull
    private final Consultant consultant;

    @NotNull
    private  Competence competence;

    private  LocalDateTime disponibilite;

    private  Modalite modalite;

    public RenseignementsCommand(Consultant consultant, Competence competence) {
        this.consultant = consultant;
        this.competence = competence;
    }

    public RenseignementsCommand(Consultant consultant, LocalDateTime disponibilite) {
        this.consultant = consultant;
        this.disponibilite = disponibilite;
    }

    public RenseignementsCommand(Consultant consultant, Modalite modalite) {
        this.consultant = consultant;
        this.modalite = modalite;
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
}
