package com.esiea.pootd2.commands;

public class ChangeDirectoryCommand extends Command {
    private final String path;

    public ChangeDirectoryCommand(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
