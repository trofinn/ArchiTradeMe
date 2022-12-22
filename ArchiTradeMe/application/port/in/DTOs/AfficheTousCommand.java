package application.port.in.DTOs;

import application.port.out.Repository;

public class AfficheTousCommand {
    private final Repository repository;

    public AfficheTousCommand(Repository repository) {
        this.repository = repository;
    }
}
