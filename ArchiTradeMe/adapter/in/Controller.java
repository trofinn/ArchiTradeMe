package adapter.in;

import application.port.in.DTOs.InscriptionCommand;
import application.port.in.DTOs.RenseignementsCommand;
import domain.Competence;
import domain.Consultant;
import kernel.CommandBus;

public class Controller {
    private final CommandBus commandBus;

    public Controller(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    public Consultant inscription(String email, String nom, String prenom) {
        return (Consultant) commandBus.post(new InscriptionCommand(email, nom, prenom));
    }

    public Consultant add_competence(Consultant consultant, Competence competence) {
        return (Consultant) commandBus.post(new RenseignementsCommand(consultant, competence));
    }

    /*
    public Consultant delete_competence(Consultant consultant, Competence competence) {
        return renseignementsUseCase.delete_competence(new RenseignementsCommand(consultant,competence));
    }*/
}
