package dev.dankom.commands.command;

import dev.dankom.commands.command.commands.HelpCommand;
import dev.dankom.commands.command.commands.SetupCommand;
import dev.dankom.util.general.args.ArgParser;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private static List<Command> commands;

    public CommandManager() {
        commands = new ArrayList<>();

        addCommand(new HelpCommand());
        addCommand(new SetupCommand());
    }

    public static void run(String[] argsToParse) {
        ArgParser.ArgList args = parseArgs(argsToParse);
        for (Command c : commands) {
            if (args.get("-" + c.getName()) != null && (boolean) args.get("-" + c.getName()).getValue()) {
                c.run(args);
                return;
            }
        }
        System.out.println("Unknown Command! Run -help if you need help!");
    }

    public static ArgParser.ArgList parseArgs(String[] argsToParse) {
        ArgParser parser = new ArgParser();
        for (Command c : commands) {
            parser.addArg(new ArgParser.Arg("-" + c.getName(), false, true, false));
        }
        //Extra
        parser.addArg(new ArgParser.Arg("-path", "./", false, false));
        //
        return parser.parseArgs(argsToParse);
    }

    public static void addCommand(Command command) {
        commands.add(command);
    }

    public static List<Command> commands() {
        return commands;
    }

    static {
        if (commands == null) {
            new CommandManager();
        }
    }
}
