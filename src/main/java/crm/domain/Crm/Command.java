package crm.domain.Crm;

public enum Command {

    HELP("--help"),
    EXIT("exit"),
    INVALID("invalid"),
    ;

    private final String command;

    public String getCommand()
    {
        return this.command;
    }

    private Command(String command)
    {
        this.command = command;
    }

    public static Command fromString(String text) {
        for (Command b : Command.values()) {
            if (b.command.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return Command.INVALID;
    }
}


