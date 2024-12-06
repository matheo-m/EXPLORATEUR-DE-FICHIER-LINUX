package com.esiea.pootd2.commands;

public class TouchCommand extends Command {
    private final String fileName;

    public TouchCommand(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
