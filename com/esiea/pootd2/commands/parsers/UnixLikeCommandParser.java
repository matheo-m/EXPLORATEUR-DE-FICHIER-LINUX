package com.esiea.pootd2.commands.parsers;

import com.esiea.pootd2.commands.ChangeDirectoryCommand;
import com.esiea.pootd2.commands.Command;
import com.esiea.pootd2.commands.ErrorCommand;
import com.esiea.pootd2.commands.ListCommand;
import com.esiea.pootd2.commands.MakeDirectoryCommand;
import com.esiea.pootd2.commands.PwdCommand;
import com.esiea.pootd2.commands.TouchCommand;

public class UnixLikeCommandParser implements ICommandParser {

    @Override
    public Command parse(String commandStr) {
        if (commandStr == null || commandStr.trim().isEmpty()) {
            return new ErrorCommand("Empty command");
        }

        String[] parts = splitArguments(commandStr);
        if (parts.length == 0) {
            return new ErrorCommand("Invalid command");
        }

        return mapCommand(parts);
    }

    private String[] splitArguments(String commandStr) {
        // Sépare les arguments par les espaces, en évitant les espaces inutiles
        return commandStr.trim().split("\\s+");
    }

    private Command mapCommand(String[] parts) {
        String command = parts[0];

        switch (command) {
            case "ls":
                return new ListCommand();
            case "pwd":
                return new PwdCommand();
            case "cd":
                if (parts.length < 2) {
                    return new ErrorCommand("cd requires a path argument");
                }
                return new ChangeDirectoryCommand(parts[1]);
            case "mkdir":
                if (parts.length < 2) {
                    return new ErrorCommand("mkdir requires a directory name");
                }
                return new MakeDirectoryCommand(parts[1]);
            case "touch":
                if (parts.length < 2) {
                    return new ErrorCommand("touch requires a file name");
                }
                return new TouchCommand(parts[1]);
            default:
                return new ErrorCommand("Unknown command: " + command);
        }
    }
}
