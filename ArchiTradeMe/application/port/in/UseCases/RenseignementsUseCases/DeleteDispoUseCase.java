package application.port.in.UseCases.RenseignementsUseCases;

import application.port.in.DTOs.RenseignementsCommand;
import domain.Consultant;

public interface DeleteDispoUseCase {
    Consultant delete_dispo(RenseignementsCommand renseignementsCommand);
}
