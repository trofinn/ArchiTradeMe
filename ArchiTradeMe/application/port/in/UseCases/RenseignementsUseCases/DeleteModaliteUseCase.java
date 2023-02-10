package application.port.in.UseCases.RenseignementsUseCases;

import application.port.in.DTOs.RenseignementsCommand;
import domain.Consultant;

public interface DeleteModaliteUseCase {
    Consultant delete_modalite(RenseignementsCommand renseignementsCommand);
}
