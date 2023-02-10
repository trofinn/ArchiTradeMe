package application.port.in.UseCases.RenseignementsUseCases;

import application.port.in.DTOs.RenseignementsCommand;
import domain.Consultant;

public interface AddDispoUseCase {
    Consultant add_dispo(RenseignementsCommand renseignementsCommand);
}
