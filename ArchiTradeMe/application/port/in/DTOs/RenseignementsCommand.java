package application.port.in.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private  LocalDateTime disponibilite;

    private  Modalite modalite;

    private String TJM;

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

    public RenseignementsCommand(Consultant consultant, String TJM) {
        this.consultant = consultant;
        this.TJM = TJM;
    }

    public Consultant getConsultant() {
        return consultant;
    }

    public Competence getCompetence() {
        return competence;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getDisponibilite() {
        return disponibilite;
    }

    public String getTJM() {return TJM;}

    public Modalite getModalite() {
        return modalite;
    }
}
