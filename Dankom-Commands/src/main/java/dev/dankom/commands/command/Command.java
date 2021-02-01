package dev.dankom.commands.command;

import dev.dankom.util.general.args.ArgParser;

public interface Command {
    void run(ArgParser.ArgList args);
    String getName();
    String getHelp();
}
