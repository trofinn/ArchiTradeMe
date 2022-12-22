package application.port.in.UseCases;


import application.port.in.DTOs.AfficheConsultantCommand;
import domain.Consultant;

public interface AfficheConsultantUseCase {
    Consultant recherche_consultant(AfficheConsultantCommand afficheConsultantCommand);
}
