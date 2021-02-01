package dev.dankom.commands.command.commands;

import dev.dankom.commands.command.Command;
import dev.dankom.file.bat.BatFile;
import dev.dankom.file.sh.ShFile;
import dev.dankom.util.general.args.ArgParser;

import java.io.File;

public class SetupCommand implements Command {
    @Override
    public void run(ArgParser.ArgList args) {
        ShFile dankom_core_sh = new ShFile(new File(
                (String) args.get("-path").getValue()),
                "dankom-core",
                "java -jar Dankom-Commands-1.0.jar $1 $2 $3 $4 $5 $6 $7 $8 $9",
                true);
        BatFile dankom_core_bat = new BatFile(new File(
                (String) args.get("-path").getValue()),
                "dankom-core",
                "java -jar Dankom-Commands-1.0.jar %1 %2 %3 %4 %5 %6 %7 %8 %9",
                true);
    }

    @Override
    public String getName() {
        return "setup";
    }

    @Override
    public String getHelp() {
        return "Creates sh scripts to make it easier to run commands";
    }
}
