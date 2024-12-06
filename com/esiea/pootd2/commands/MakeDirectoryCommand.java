package com.esiea.pootd2.commands;

public class MakeDirectoryCommand extends Command {
    private final String directoryName;

    public MakeDirectoryCommand(String directoryName) {
        this.directoryName = directoryName;
    }

    public String getDirectoryName() {
        return directoryName;
    }
}
