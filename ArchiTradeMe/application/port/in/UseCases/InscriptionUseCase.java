package application.port.in.UseCases;


import application.port.in.DTOs.InscriptionCommand;
import domain.Consultant;

public interface InscriptionUseCase {
    Consultant inscription(InscriptionCommand inscriptionCommand);
}
