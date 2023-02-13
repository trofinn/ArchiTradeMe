package application.events.Renseignements;

import domain.Competence;
import domain.Consultant;
import kernel.Event;

public class CompetenceDeletedEvent implements Event{
    private final Consultant consultant;

    private Competence competence;

    public CompetenceDeletedEvent(Consultant consultant, Competence competence) {
        this.consultant = consultant;
        this.competence = competence;
    }

    public Consultant getConsultant() {
        return consultant;
    }

    public Competence getCompetence() {
        return competence;
    }
}
