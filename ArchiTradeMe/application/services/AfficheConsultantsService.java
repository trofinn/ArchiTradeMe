package application.services;

import application.port.in.DTOs.AfficheConsultantCommand;
import application.port.in.UseCases.AfficheConsultantUseCase;
import application.port.out.Repository;
import domain.Consultant;

public class AfficheConsultantsService implements AfficheConsultantUseCase {
    private final Repository repository;

    public AfficheConsultantsService(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Consultant recherche_consultant(AfficheConsultantCommand afficheConsultantCommand) {
        return repository.load(afficheConsultantCommand.email);
    }
}
