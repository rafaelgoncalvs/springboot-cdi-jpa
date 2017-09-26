package springbootcdijpa.application.command.base;

public class CommandConfirmation {

    private String value;

    private CommandConfirmation() {
        this.value = "";
    }

    private CommandConfirmation(String value) {
        this.value = value;
    }

    public static CommandConfirmation empty() {
        return new CommandConfirmation();
    }

    public static CommandConfirmation of(String value) {
        return new CommandConfirmation(value);
    }

    public static CommandConfirmation of(Long value) {
        return new CommandConfirmation(value.toString());
    }

    public String value() {
        return value;
    }
}
