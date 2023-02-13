package application.services.renseignements_services;

import application.events.Renseignements.ModaliteDeletedEvent;
import application.events.Renseignements.TJMUpdatedEvent;
import application.port.in.DTOs.RenseignementsCommand;
import application.port.in.UseCases.RenseignementsUseCases.DeleteModaliteUseCase;
import application.port.out.Repository;
import domain.Consultant;
import kernel.Event;
import kernel.EventDispatcher;

public class DeleteModaliteService implements DeleteModaliteUseCase {
    private final Repository repository;
    private final EventDispatcher<? super Event> eventDispatcher;

    public DeleteModaliteService(Repository repository, EventDispatcher<? super Event> eventDispatcher) {
        this.repository = repository;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public Consultant delete_modalite(RenseignementsCommand renseignementsCommand) {
        Consultant consultant = renseignementsCommand.getConsultant().delete_modalite(renseignementsCommand.getModalite());
        repository.save(consultant);
        eventDispatcher.dispatch(new ModaliteDeletedEvent(consultant,renseignementsCommand.getModalite()));
        return consultant;

    }
}
