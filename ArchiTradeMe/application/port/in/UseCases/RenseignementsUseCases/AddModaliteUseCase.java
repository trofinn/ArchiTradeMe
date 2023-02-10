package application.port.in.UseCases.RenseignementsUseCases;

import application.port.in.DTOs.RenseignementsCommand;
import domain.Consultant;

public interface AddModaliteUseCase {
    Consultant add_modalite(RenseignementsCommand renseignementsCommand);
}
