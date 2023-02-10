package application.services;

import application.events.ClientAccountCreatedEvent;
import application.port.in.DTOs.InscriptionClientCommand;
import application.port.in.UseCases.InscriptionClientUseCase;
import application.port.out.Repository;
import domain.Client;
import kernel.Event;
import kernel.EventDispatcher;

public class InscriptionClientService implements InscriptionClientUseCase {

    private final Repository repository;
    private final EventDispatcher<? super Event> eventDispatcher;

    public InscriptionClientService(Repository repository, EventDispatcher<? super Event> eventDispatcher) {
        this.repository = repository;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public Client inscription(InscriptionClientCommand inscriptionClientCommand) {
        Client client = new Client(inscriptionClientCommand.getEmail(),inscriptionClientCommand.getNom(),inscriptionClientCommand.getPrenom());
        repository.save(client);
        eventDispatcher.dispatch(new ClientAccountCreatedEvent(inscriptionClientCommand.getEmail(),inscriptionClientCommand.getNom(),
                inscriptionClientCommand.getPrenom()));
        return client;
    }
}
