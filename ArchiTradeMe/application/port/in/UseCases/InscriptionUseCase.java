package application.port.in.UseCases;

import application.port.in.DTOs.InscriptionCommand;
import domain.*;
import kernel.CommandHandler;

public interface InscriptionUseCase extends CommandHandler<InscriptionCommand, Consultant> {
}
