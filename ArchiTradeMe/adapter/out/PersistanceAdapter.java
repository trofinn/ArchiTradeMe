package adapter.out;

import application.port.out.Repository;
import domain.Consultant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PersistanceAdapter implements Repository {
    private final Map<String, Consultant> registry = new HashMap<>();
    @Override
    public void save(Consultant consultant) {
        registry.put(consultant.getEmail(),consultant);
    }

    @Override
    public Consultant load(String nom, String prenom) {
        return null;
    }

    @Override
    public ArrayList<Consultant> findAll() {
        return new ArrayList<Consultant>(registry.values());
    }
}
