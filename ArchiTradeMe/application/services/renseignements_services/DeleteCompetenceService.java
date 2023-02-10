package application.services.renseignements_services;

import application.events.Renseignements.RenseignementsAddedEvent;
import application.port.in.DTOs.RenseignementsCommand;
import application.port.in.UseCases.RenseignementsUseCases.DeleteCompetenceUseCase;
import application.port.out.Repository;
import domain.Consultant;
import kernel.Event;
import kernel.EventDispatcher;

public class DeleteCompetenceService implements DeleteCompetenceUseCase {

    private final Repository repository;
    private final EventDispatcher<? super Event> eventDispatcher;

    public DeleteCompetenceService(Repository repository, EventDispatcher<? super Event> eventDispatcher) {
        this.repository = repository;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public Consultant delete_competence(RenseignementsCommand renseignementsCommand) {
        Consultant consultant = renseignementsCommand.getConsultant().delete_competence(renseignementsCommand.getCompetence());
        eventDispatcher.dispatch(new RenseignementsAddedEvent(consultant,renseignementsCommand.getCompetence()));
        repository.save(consultant);
        return consultant;
    }
}
