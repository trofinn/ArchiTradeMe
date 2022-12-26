package application.services;

import application.events.RenseignementsAddedEvent;
import application.port.in.DTOs.RenseignementsCommand;
import application.port.in.UseCases.RenseignementsUseCase;
import application.port.out.Repository;
import domain.Consultant;
import kernel.Event;
import kernel.EventDispatcher;

public class RenseignementsService implements RenseignementsUseCase {

    private final Repository repository;
    private final EventDispatcher<? super Event> eventDispatcher;

    public RenseignementsService(Repository repository, EventDispatcher<? super Event> eventDispatcher) {
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

    @Override
    public Consultant delete_competence(RenseignementsCommand renseignementsCommand) {
        Consultant consultant = renseignementsCommand.getConsultant().delete_competence(renseignementsCommand.getCompetence());
        eventDispatcher.dispatch(new RenseignementsAddedEvent(consultant,renseignementsCommand.getCompetence()));
        repository.save(consultant);
        return consultant;
    }

    @Override
    public Consultant add_dispo(RenseignementsCommand renseignementsCommand) {
        Consultant consultant = renseignementsCommand.getConsultant().add_dispo(renseignementsCommand.getDisponibilite());
        eventDispatcher.dispatch(new RenseignementsAddedEvent(consultant,renseignementsCommand.getDisponibilite()));
        repository.save(consultant);
        return consultant;
    }

    @Override
    public Consultant delete_dispo(RenseignementsCommand renseignementsCommand) {
        Consultant consultant = renseignementsCommand.getConsultant().delete_dispo(renseignementsCommand.getDisponibilite());
        repository.save(consultant);
        eventDispatcher.dispatch(new RenseignementsAddedEvent(consultant,renseignementsCommand.getDisponibilite()));
        return consultant;
    }

    @Override
    public Consultant add_modalite(RenseignementsCommand renseignementsCommand) {
        Consultant consultant = renseignementsCommand.getConsultant().add_modalite(renseignementsCommand.getModalite());
        repository.save(consultant);
        eventDispatcher.dispatch(new RenseignementsAddedEvent(consultant,renseignementsCommand.getModalite()));
        return consultant;
    }

    @Override
    public Consultant delete_modalite(RenseignementsCommand renseignementsCommand) {
        Consultant consultant = renseignementsCommand.getConsultant().delete_modalite(renseignementsCommand.getModalite());
        repository.save(consultant);
        eventDispatcher.dispatch(new RenseignementsAddedEvent(consultant,renseignementsCommand.getModalite()));
        return consultant;

    }

    @Override
    public Consultant set_TJM(RenseignementsCommand renseignementsCommand) {
        Consultant consultant = renseignementsCommand.getConsultant().set_TJM(renseignementsCommand.getTJM());
        repository.save(consultant);
        eventDispatcher.dispatch(new RenseignementsAddedEvent(consultant,renseignementsCommand.getTJM()));
        return consultant;
    }
}
