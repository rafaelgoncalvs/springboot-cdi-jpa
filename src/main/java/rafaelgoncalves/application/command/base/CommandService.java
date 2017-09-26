package rafaelgoncalves.application.command.base;

public interface CommandService<C extends Command> {
    CommandConfirmation execute(C c);
}
