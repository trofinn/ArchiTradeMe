package application.services;

import application.port.in.DTOs.InscriptionClientCommand;
import application.port.in.UseCases.InscriptionClientUseCase;
import application.port.out.Repository;
import domain.Client;

public class ClientService implements InscriptionClientUseCase {

    private final Repository repository;

    public ClientService(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Client inscription(InscriptionClientCommand inscriptionClientCommand) {
        Client client = new Client(inscriptionClientCommand.getEmail(),inscriptionClientCommand.getNom(),inscriptionClientCommand.getPrenom());
        repository.save(client);
        return client;
    }
}
