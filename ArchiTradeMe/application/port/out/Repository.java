package application.port.out;

import domain.Consultant;

import java.util.ArrayList;

public interface Repository {
    void save(Consultant consultant);
    Consultant load(String email);
    ArrayList<Consultant> findAll();
    void update(Consultant consultant);
}
