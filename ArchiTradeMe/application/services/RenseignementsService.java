package application.services;

import application.port.in.DTOs.RenseignementsCommand;
import application.port.in.UseCases.RenseignementsUseCase;
import application.port.out.Repository;
import domain.Competence;
import domain.Consultant;

import java.util.ArrayList;

public class RenseignementsService implements RenseignementsUseCase {

    private final Repository repository;

    public RenseignementsService(Repository repository) {
        this.repository = repository;
    }


    @Override
    public Consultant add_competence(RenseignementsCommand renseignementsCommand) {
        Consultant consultant = renseignementsCommand.getConsultant().add_competence(renseignementsCommand.getCompetence());
        repository.save(consultant);
        return consultant;
    }

    @Override
    public Consultant delete_competence(RenseignementsCommand renseignementsCommand) {
        Consultant consultant = renseignementsCommand.getConsultant().delete_competence(renseignementsCommand.getCompetence());
        repository.save(consultant);
        return consultant;
    }

    @Override
    public Consultant add_dispo(RenseignementsCommand renseignementsCommand) {
        Consultant consultant = renseignementsCommand.getConsultant().add_dispo(renseignementsCommand.getDisponibilite());
        repository.save(consultant);
        return consultant;
    }

    @Override
    public Consultant delete_dispo(RenseignementsCommand renseignementsCommand) {
        Consultant consultant = renseignementsCommand.getConsultant().delete_dispo(renseignementsCommand.getDisponibilite());
        repository.save(consultant);
        return consultant;
    }

    @Override
    public Consultant add_modalite(RenseignementsCommand renseignementsCommand) {
        Consultant consultant = renseignementsCommand.getConsultant().add_modalite(renseignementsCommand.getModalite());
        repository.save(consultant);
        return consultant;
    }

    @Override
    public Consultant delete_modalite(RenseignementsCommand renseignementsCommand) {
        Consultant consultant = renseignementsCommand.getConsultant().delete_modalite(renseignementsCommand.getModalite());
        repository.save(consultant);
        return consultant;

    }

    @Override
    public Consultant set_TJM(RenseignementsCommand renseignementsCommand) {
        Consultant consultant = renseignementsCommand.getConsultant().set_TJM(renseignementsCommand.getTJM());
        repository.save(consultant);
        return consultant;
    }
}
