package springbootcdijpa.application.command;

import springbootcdijpa.application.command.base.Command;

public class RemoveUser implements Command {

    private Long id;

    public RemoveUser(Long id) {
        this.id = id;
    }

    public Long id() {
        return id;
    }
}
