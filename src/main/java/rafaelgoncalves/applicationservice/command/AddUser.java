package rafaelgoncalves.applicationservice.command;

import rafaelgoncalves.applicationservice.command.base.Command;

public class AddUser implements Command {

    private String name;

    public AddUser(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }
}
