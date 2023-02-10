package application.services.renseignements_services;

import application.events.Renseignements.RenseignementsAddedEvent;
import application.port.in.DTOs.RenseignementsCommand;
import application.port.in.UseCases.RenseignementsUseCases.AddCompetenceUseCase;
import application.port.out.Repository;
import domain.Consultant;
import kernel.Event;
import kernel.EventDispatcher;

public class AddCompetenceService implements AddCompetenceUseCase {
    private final Repository repository;
    private final EventDispatcher<? super Event> eventDispatcher;

    public AddCompetenceService(Repository repository, EventDispatcher<? super Event> eventDispatcher) {
        this.repository = repository;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public Consultant add_competence(RenseignementsCommand renseignementsCommand) {
        Consultant consultant = renseignementsCommand.getConsultant().add_competence(renseignementsCommand.getCompetence());
        repository.save(consultant);
        eventDispatcher.dispatch(new RenseignementsAddedEvent(consultant,renseignementsCommand.getCompetence()));
        return consultant;
    }
}
