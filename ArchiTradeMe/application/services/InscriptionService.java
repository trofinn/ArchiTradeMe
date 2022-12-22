package application.services;

import application.port.in.DTOs.InscriptionCommand;
import application.port.in.UseCases.InscriptionUseCase;
import application.port.out.Repository;
import domain.Consultant;

public class InscriptionService implements InscriptionUseCase {
    private final Repository repository;

    public InscriptionService(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Consultant inscription(InscriptionCommand inscriptionCommand) {
        Consultant consultant = new Consultant(inscriptionCommand.getEmail(),inscriptionCommand.getNom(),inscriptionCommand.getPrenom());
        repository.save(consultant);
        return consultant;
    }
}
