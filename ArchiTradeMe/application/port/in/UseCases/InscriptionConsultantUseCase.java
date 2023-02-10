package application.port.in.UseCases;


import application.port.in.DTOs.InscriptionConsultantCommand;
import domain.Consultant;

public interface InscriptionConsultantUseCase {
    Consultant inscription(InscriptionConsultantCommand inscriptionConsultantCommand);
}
