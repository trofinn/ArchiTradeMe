package application.port.in.UseCases;

import application.port.in.DTOs.RenseignementsCommand;
import domain.Consultant;

import kernel.CommandHandler;

public interface RenseignementsUseCase extends CommandHandler<RenseignementsCommand, Consultant> {
    //Consultant add_competence(RenseignementsCommand renseignementsCommand);
    /*
    Consultant delete_competence(RenseignementsCommand renseignementsCommand);
    Consultant add_dispo(RenseignementsCommand renseignementsCommand);
    Consultant delete_dispo(RenseignementsCommand renseignementsCommand);
    Consultant add_modalite(RenseignementsCommand renseignementsCommand);
    Consultant delete_modalite(RenseignementsCommand renseignementsCommand);
    Consultant set_TJM(RenseignementsCommand renseignementsCommand);
     */
}
