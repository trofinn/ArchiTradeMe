package application.services;

import application.port.in.DTOs.AfficheClientCommand;
import application.port.in.UseCases.AfficheClientUseCase;
import application.port.out.Repository;
import domain.Client;

public class AfficheClientService implements AfficheClientUseCase {
    private final Repository repository;

    public AfficheClientService(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Client affiche_client(AfficheClientCommand afficheClientCommand) {
        return repository.load_client(afficheClientCommand.email);
    }
}
