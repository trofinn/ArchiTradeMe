package application.port.in.UseCases;

import application.port.in.DTOs.AfficheClientCommand;
import domain.Client;

public interface AfficheClientUseCase {
    Client affiche_client(AfficheClientCommand afficheClientCommand);
}
