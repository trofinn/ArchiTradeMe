package application.port.in.UseCases.RenseignementsUseCases;

import application.port.in.DTOs.RenseignementsCommand;
import domain.Consultant;

public interface DeleteCompetenceUseCase {
    Consultant delete_competence(RenseignementsCommand renseignementsCommand);
}
