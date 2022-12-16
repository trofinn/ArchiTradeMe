package application.services;

import application.port.in.DTOs.RenseignementsCommand;
import application.port.in.UseCases.RenseignementsUseCase;
import application.port.out.Repository;
import domain.Consultant;

public class RenseignementsService implements RenseignementsUseCase {

    private final Repository repository;

    public RenseignementsService(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Consultant handle(RenseignementsCommand renseignementsCommand) {
       Consultant consultant = renseignementsCommand.getConsultant().add_competence(renseignementsCommand.getCompetence());
       repository.save(consultant);
       return consultant;
    }

    /*
    @Override
    public Consultant delete_competence(RenseignementsCommand renseignementsCommand) {
        Consultant consultant = renseignementsCommand.getConsultant().delete_competence(renseignementsCommand.getCompetence());
        repository.save(consultant);
        return consultant;
    }

    @Override
    public Consultant add_dispo(RenseignementsCommand renseignementsCommand) {
        return null;
    }

    @Override
    public Consultant delete_dispo(RenseignementsCommand renseignementsCommand) {
        return null;
    }

    @Override
    public Consultant add_modalite(RenseignementsCommand renseignementsCommand) {
        return null;
    }

    @Override
    public Consultant delete_modalite(RenseignementsCommand renseignementsCommand) {
        return null;
    }

    @Override
    public Consultant set_TJM(RenseignementsCommand renseignementsCommand) {
        return null;
    }*/
}
