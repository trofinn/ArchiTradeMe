package application.services;

import application.events.ConsultantAccountCreatedEvent;
import application.port.in.DTOs.InscriptionConsultantCommand;
import application.port.in.UseCases.InscriptionConsultantUseCase;
import application.port.out.Repository;
import domain.Consultant;
import kernel.Event;
import kernel.EventDispatcher;

public class InscriptionConsultantConsultantService implements InscriptionConsultantUseCase {
    private final Repository repository;
    private final EventDispatcher<? super Event> eventDispatcher;

    public InscriptionConsultantConsultantService(Repository repository, EventDispatcher<? super Event> eventDispatcher) {
        this.repository = repository;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public Consultant inscription(InscriptionConsultantCommand inscriptionConsultantCommand) {
        Consultant consultant = new Consultant(inscriptionConsultantCommand.getEmail(), inscriptionConsultantCommand.getNom(), inscriptionConsultantCommand.getPrenom());
        repository.save(consultant);
        eventDispatcher.dispatch(new ConsultantAccountCreatedEvent(inscriptionConsultantCommand.getEmail(),
                inscriptionConsultantCommand.getNom(),
                inscriptionConsultantCommand.getPrenom()));
        return consultant;
    }
}
