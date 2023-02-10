package application.port.in.UseCases;

import application.port.in.DTOs.InscriptionClientCommand;
import domain.Client;

public interface InscriptionClientUseCase {
    Client inscription(InscriptionClientCommand inscriptionClientCommand);
}
