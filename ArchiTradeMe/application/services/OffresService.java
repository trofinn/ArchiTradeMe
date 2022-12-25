package application.services;

import application.port.in.DTOs.AjouterOffreCommand;
import application.port.in.UseCases.AjouterOffreUseCase;
import application.port.out.Repository;
import domain.Client;
import domain.Offre;

public class OffresService implements AjouterOffreUseCase {
    private final Repository repository;

    public OffresService(Repository repository) {
        this.repository = repository;
    }


    @Override
    public Client ajouter_offre(AjouterOffreCommand ajouterOffreCommand) {
        Offre offre = new Offre(ajouterOffreCommand.offre.getId(),ajouterOffreCommand.offre.getTJM(),
                ajouterOffreCommand.getOffre().getComeptences_necessaires(), ajouterOffreCommand.getOffre().getModalites(),
                ajouterOffreCommand.offre.getDate_debut(),ajouterOffreCommand.offre.getDuration());

        Client client = ajouterOffreCommand.client;
        client.add_offre(offre);
        repository.save(client);
        return client;
    }
}
