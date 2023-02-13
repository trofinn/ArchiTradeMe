package application.services.renseignements_services;

import application.events.Renseignements.DispoDeletedEvent;
import application.events.Renseignements.TJMUpdatedEvent;
import application.port.in.DTOs.RenseignementsCommand;
import application.port.in.UseCases.RenseignementsUseCases.DeleteDispoUseCase;
import application.port.out.Repository;
import domain.Consultant;
import kernel.Event;
import kernel.EventDispatcher;

public class DeleteDispoService implements DeleteDispoUseCase {
    private final Repository repository;
    private final EventDispatcher<? super Event> eventDispatcher;

    public DeleteDispoService(Repository repository, EventDispatcher<? super Event> eventDispatcher) {
        this.repository = repository;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public Consultant delete_dispo(RenseignementsCommand renseignementsCommand) {
        Consultant consultant = renseignementsCommand.getConsultant().delete_dispo(renseignementsCommand.getDisponibilite());
        repository.save(consultant);
        eventDispatcher.dispatch(new DispoDeletedEvent(consultant,renseignementsCommand.getDisponibilite()));
        return consultant;
    }
}
