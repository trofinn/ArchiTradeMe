package application.port.out;

import domain.Consultant;

import java.util.ArrayList;

public interface Repository {
    void save(Consultant consultant);
    Consultant load(String nom, String prenom);
    ArrayList<Consultant> findAll();
}
