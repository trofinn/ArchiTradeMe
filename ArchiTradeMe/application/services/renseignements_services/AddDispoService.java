package application.services.renseignements_services;

import application.events.Renseignements.DispoAddedEvent;
import application.events.Renseignements.TJMUpdatedEvent;
import application.port.in.DTOs.RenseignementsCommand;
import application.port.in.UseCases.RenseignementsUseCases.AddDispoUseCase;
import application.port.out.Repository;
import domain.Consultant;
import kernel.Event;
import kernel.EventDispatcher;

public class AddDispoService implements AddDispoUseCase {
    private final Repository repository;
    private final EventDispatcher<? super Event> eventDispatcher;

    public AddDispoService(Repository repository, EventDispatcher<? super Event> eventDispatcher) {
        this.repository = repository;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public Consultant add_dispo(RenseignementsCommand renseignementsCommand) {
        Consultant consultant = renseignementsCommand.getConsultant().add_dispo(renseignementsCommand.getDisponibilite());
        eventDispatcher.dispatch(new DispoAddedEvent(consultant,renseignementsCommand.getDisponibilite()));
        repository.save(consultant);
        return consultant;
    }
}
