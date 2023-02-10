package application.port.in.UseCases.RenseignementsUseCases;

import application.port.in.DTOs.RenseignementsCommand;
import domain.Consultant;

public interface AddCompetenceUseCase {
    Consultant add_competence(RenseignementsCommand renseignementsCommand);
}
