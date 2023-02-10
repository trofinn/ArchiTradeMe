package application.port.out;

import domain.Client;
import domain.Consultant;

import java.util.ArrayList;

public interface Repository {
    void save(Consultant consultant);
    void save(Client client);
    Consultant load(String email);
    Client load_client(String email);
    ArrayList<Consultant> findAll();
    void update(Consultant consultant);
}
