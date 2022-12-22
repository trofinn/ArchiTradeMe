package application.port.in.DTOs;



import javax.validation.constraints.NotNull;

public class AfficheConsultantCommand {
    @NotNull
    public String email;

    public AfficheConsultantCommand(String email) {
        this.email = email;
    }
}
