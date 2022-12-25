package application.port.in.DTOs;

import javax.validation.constraints.NotNull;

public class AfficheClientCommand {
    @NotNull
    public final String email;

    public AfficheClientCommand(String email) {
        this.email = email;
    }

}
