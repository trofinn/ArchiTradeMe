package application.port.in.UseCases;


import application.port.in.DTOs.InscriptionConsultantCommand;
import domain.Consultant;

public interface InscriptionUseCase {
    Consultant inscription(InscriptionConsultantCommand inscriptionConsultantCommand);
}
