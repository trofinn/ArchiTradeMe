package application.services.renseignements_services;

import application.events.Renseignements.RenseignementsAddedEvent;
import application.port.in.DTOs.RenseignementsCommand;
import application.port.in.UseCases.RenseignementsUseCases.AddModaliteUseCase;
import application.port.out.Repository;
import domain.Consultant;
import kernel.Event;
import kernel.EventDispatcher;

public class AddModaliteService implements AddModaliteUseCase {
    private final Repository repository;
    private final EventDispatcher<? super Event> eventDispatcher;

    public AddModaliteService(Repository repository, EventDispatcher<? super Event> eventDispatcher) {
        this.repository = repository;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public Consultant add_modalite(RenseignementsCommand renseignementsCommand) {
        Consultant consultant = renseignementsCommand.getConsultant().add_modalite(renseignementsCommand.getModalite());
        repository.save(consultant);
        eventDispatcher.dispatch(new RenseignementsAddedEvent(consultant,renseignementsCommand.getModalite()));
        return consultant;
    }
}
