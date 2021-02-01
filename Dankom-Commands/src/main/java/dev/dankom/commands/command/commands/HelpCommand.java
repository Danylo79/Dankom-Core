package dev.dankom.commands.command.commands;

import dev.dankom.commands.command.Command;
import dev.dankom.commands.command.CommandManager;
import dev.dankom.util.general.args.ArgParser;

public class HelpCommand implements Command {
    @Override
    public void run(ArgParser.ArgList args) {
        for (Command c : CommandManager.commands()) {
            System.out.println(c.getName() + " - " + c.getHelp());
        }
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getHelp() {
        return "Shows all commands";
    }
}
