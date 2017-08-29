package rafaelgoncalves.applicationservice.command;

import rafaelgoncalves.applicationservice.command.base.Command;

public class RemoveUser implements Command {

    private Long id;

    public RemoveUser(Long id) {
        this.id = id;
    }

    public Long id() {
        return id;
    }
}
