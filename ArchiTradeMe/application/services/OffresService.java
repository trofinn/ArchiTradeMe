package application.services;

import application.events.OffertAddedEvent;
import application.port.in.DTOs.AjouterOffreCommand;
import application.port.in.UseCases.AjouterOffreUseCase;
import application.port.out.Repository;
import domain.Client;
import domain.Offre;
import kernel.Event;
import kernel.EventDispatcher;

public class OffresService implements AjouterOffreUseCase {
    private final Repository repository;
    private final EventDispatcher<? super Event> eventDispatcher;

    public OffresService(Repository repository, EventDispatcher<? super Event> eventDispatcher) {
        this.repository = repository;
        this.eventDispatcher = eventDispatcher;
    }


    @Override
    public Client ajouter_offre(AjouterOffreCommand ajouterOffreCommand) {
        Offre offre = new Offre(ajouterOffreCommand.offre.getId(),ajouterOffreCommand.offre.getTJM(),
                ajouterOffreCommand.getOffre().getComeptences_necessaires(), ajouterOffreCommand.getOffre().getModalites(),
                ajouterOffreCommand.offre.getDate_debut(),ajouterOffreCommand.offre.getDuration());

        Client client = ajouterOffreCommand.client;
        client.add_offre(offre);
        eventDispatcher.dispatch(new OffertAddedEvent(ajouterOffreCommand.client,ajouterOffreCommand.offre));
        repository.save(client);
        return client;
    }
}
