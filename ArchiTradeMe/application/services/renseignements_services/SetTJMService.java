package application.services.renseignements_services;

import application.events.Renseignements.RenseignementsAddedEvent;
import application.port.in.DTOs.RenseignementsCommand;
import application.port.in.UseCases.RenseignementsUseCases.SetTJMUseCase;
import application.port.out.Repository;
import domain.Consultant;
import kernel.Event;
import kernel.EventDispatcher;

public class SetTJMService implements SetTJMUseCase {

    private final Repository repository;
    private final EventDispatcher<? super Event> eventDispatcher;


    public SetTJMService(Repository repository, EventDispatcher<? super Event> eventDispatcher) {
        this.repository = repository;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public Consultant set_TJM(RenseignementsCommand renseignementsCommand) {
        Consultant consultant = renseignementsCommand.getConsultant().set_TJM(renseignementsCommand.getTJM());
        repository.save(consultant);
        eventDispatcher.dispatch(new RenseignementsAddedEvent(consultant,renseignementsCommand.getTJM()));
        return consultant;
    }
}
