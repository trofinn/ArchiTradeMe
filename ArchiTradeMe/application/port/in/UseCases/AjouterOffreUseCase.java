package application.port.in.UseCases;

import application.port.in.DTOs.AjouterOffreCommand;
import domain.Client;
import domain.Offre;

public interface AjouterOffreUseCase {
    Client ajouter_offre(AjouterOffreCommand ajouterOffreCommand);
}
