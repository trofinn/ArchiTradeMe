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
    public Consultant load(String email) {
        return registry.computeIfAbsent(email,
                key -> {
            throw new RuntimeException("not found");
        });
    }

    @Override
    public ArrayList<Consultant> findAll() {
        return new ArrayList<Consultant>(registry.values());
    }

    @Override
    public void update(Consultant consultant) {
        registry.computeIfPresent(consultant.getEmail(), (key,val) -> consultant);
    }
}
