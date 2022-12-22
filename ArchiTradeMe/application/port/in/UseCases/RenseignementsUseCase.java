package application.port.in.UseCases;

import application.port.in.DTOs.RenseignementsCommand;
import domain.Consultant;


public interface RenseignementsUseCase {
    Consultant add_competence(RenseignementsCommand renseignementsCommand);
    Consultant delete_competence(RenseignementsCommand renseignementsCommand);
    Consultant add_dispo(RenseignementsCommand renseignementsCommand);
    Consultant delete_dispo(RenseignementsCommand renseignementsCommand);
    Consultant add_modalite(RenseignementsCommand renseignementsCommand);
    Consultant delete_modalite(RenseignementsCommand renseignementsCommand);
    Consultant set_TJM(RenseignementsCommand renseignementsCommand);
}
